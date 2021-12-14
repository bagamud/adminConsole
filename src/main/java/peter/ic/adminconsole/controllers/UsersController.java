package peter.ic.adminconsole.controllers;

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
    final DepartmentsRepository departmentsRepository;
    final PostRepository postRepository;
    final ServicesRepository servicesRepository;
    final RankRepository rankRepository;
    final RolesRepository rolesRepository;
    final UsersRepository usersRepository;

    public UsersController(DepartmentsRepository departmentsRepository, PostRepository postRepository, ServicesRepository servicesRepository, RankRepository rankRepository, RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.departmentsRepository = departmentsRepository;
        this.postRepository = postRepository;
        this.servicesRepository = servicesRepository;
        this.rankRepository = rankRepository;
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping()
    public String users(Model model) {
        serviceDictionaries(model);
        return "users";
    }

    @PostMapping("/profile")
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
            if (userProfile.getId() == 0 || (userProfile.getId() == 0 && !userProfile.getPasswd().equals(""))) {
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                userProfile.setPasswd(passwordEncoder.encode(userProfile.getPasswd()));
            }
            model.addAttribute("userProfile", usersRepository.save(userProfile));
            model.addAttribute("resultMessage", "Пользователь сохранен");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "profile";
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
        model.addAttribute("usersList", usersRepository.findAll());
    }
}