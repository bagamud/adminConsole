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
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.UsersRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    final UsersRepository usersRepository;

    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private String profile(Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping("/changePsw")
    public String changePsw(Users user, String oldPasswd, String newPasswd, BindingResult bindingResult, Model model) {
        try {
            user = usersRepository.findById(user.getId());
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(oldPasswd, user.getPasswd())) {
                user.setPasswd(passwordEncoder.encode(newPasswd));
                user = usersRepository.save(user);
                model.addAttribute("resultMessage", "Пароль успешно изменен");
            } else {
                model.addAttribute("resultMessage", "Некорректный пароль");
            }
            model.addAttribute("user", user);

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "user";
    }
}
