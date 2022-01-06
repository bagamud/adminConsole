package peter.ic.adminconsole.controllers;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    final JavaMailSender javaMailSender;
    final DepartmentsRepository departmentsRepository;
    final PostRepository postRepository;
    final ServicesRepository servicesRepository;
    final RankRepository rankRepository;
    final RolesRepository rolesRepository;
    final UsersRepository usersRepository;

    public UsersController(DepartmentsRepository departmentsRepository,
                           PostRepository postRepository,
                           ServicesRepository servicesRepository,
                           RankRepository rankRepository,
                           RolesRepository rolesRepository,
                           UsersRepository usersRepository,
                           JavaMailSender javaMailSender) {
        this.departmentsRepository = departmentsRepository;
        this.postRepository = postRepository;
        this.servicesRepository = servicesRepository;
        this.rankRepository = rankRepository;
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
        this.javaMailSender = javaMailSender;
    }

    @GetMapping()
    public String users(@RequestParam(defaultValue = "") String filter, Model model) {
        serviceDictionaries(model);
        if (!filter.equals("")) {
            String[] filterParam = filter.split("\\.");
            String type = filterParam[0];
            String value = filterParam[1];
            switch (type) {
                case "username":
                    model.addAttribute("usersList", usersRepository.findAllByUsername(value));
                    break;
                case "lastName":
                    model.addAttribute("usersList", usersRepository.findAllByLastName(value));
                    break;
                case "post":
                    model.addAttribute("usersList", usersRepository.findAllByPost_Id(Integer.parseInt(value)));
                    break;
                case "department":
                    model.addAttribute("usersList", usersRepository.findAllByDepartment_Code(Integer.parseInt(value)));
                    break;
                case "active":
                    model.addAttribute("usersList", usersRepository.findAllByActive(Boolean.parseBoolean(value)));
                    break;
                default:
                    break;
            }
        } else {
            model.addAttribute("usersList", usersRepository.findAll());
        }
        return "users";
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        serviceDictionaries(model);
        return "profile";
    }

    @GetMapping("/get")
    public String getUser(@RequestParam() String username, Model model) {
        serviceDictionaries(model);
        try {
            model.addAttribute("userProfile", usersRepository.findByUsername(username));
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "profile";
    }


    @PostMapping("/save")
    public String addUser(Users userProfile, BindingResult bindingResult, Model model) {
        serviceDictionaries(model);
        try {
            boolean needToSend = false;
            String passwd = userProfile.getPasswd();
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (userProfile.getId() == 0) {
                if (userProfile.getIdUser() == 0) {
                    userProfile.setIdUser(Math.abs(userProfile.getUsername().hashCode()));
                }
                if (userProfile.getPasswd() != null) {
                    userProfile.setPasswd(passwordEncoder.encode(userProfile.getPasswd()));
                    if (userProfile.isTemporaryPasswd()) {
                        needToSend = true;
                    }
                }
            } else {
                if (userProfile.getPasswd() == null || userProfile.getPasswd().equals("")) {
                    userProfile.setPasswd(usersRepository.findByUsername(userProfile.getUsername()).getPasswd());
                } else {
                    userProfile.setPasswd(passwordEncoder.encode(userProfile.getPasswd()));
                    if (userProfile.isTemporaryPasswd()) {
                        needToSend = true;
                    }
                }
            }
            model.addAttribute("userProfile", usersRepository.save(userProfile));
            model.addAttribute("resultMessage", "Пользователь сохранен");
            if (needToSend) sendNewPassword(userProfile, passwd);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("bindingResult", bindingResult);
        }
        return "profile";
    }

    public void sendNewPassword(Users user, String passwd) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Уведомление администратора");
        simpleMailMessage.setText("Уважаемый(ая) " + user.getFirstName() + " " + user.getSurname() + "!" +
                "\n" +
                "Вам сформирован временный пароль к порталу Вещественные доказательства:" +
                "\n" +
                passwd +
                "\n\n" +
                "После авторизации потребуется сменить пароль." +
                "Переход по ссылке: http://extr.ic.peter/bvd/login");
        javaMailSender.send(simpleMailMessage);
    }

    private void serviceDictionaries(Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);

        model.addAttribute("departments", departmentsRepository.findAll());
        model.addAttribute("post", postRepository.findAll());
        model.addAttribute("services", servicesRepository.findAll());
        model.addAttribute("rank", rankRepository.findAll());
        model.addAttribute("roles", rolesRepository.findAll());
    }

    private Users getAuthorizedUser() {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersRepository.findByUsername(userAuth.getUsername());
    }
}