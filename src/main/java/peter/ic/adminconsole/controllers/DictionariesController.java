package peter.ic.adminconsole.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.*;

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {
    final DepartmentsRepository departmentsRepository;
    final PostRepository postRepository;
    final ServicesRepository servicesRepository;
    final RankRepository rankRepository;
    final RolesRepository rolesRepository;
    final UsersRepository usersRepository;

    public DictionariesController(DepartmentsRepository departmentsRepository, PostRepository postRepository, ServicesRepository servicesRepository, RankRepository rankRepository, RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.departmentsRepository = departmentsRepository;
        this.postRepository = postRepository;
        this.servicesRepository = servicesRepository;
        this.rankRepository = rankRepository;
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping()
    public String dictionaries(Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("departments", departmentsRepository.findAll());
        model.addAttribute("post", postRepository.findAll());
        model.addAttribute("services", servicesRepository.findAll());
        model.addAttribute("rank", rankRepository.findAll());
        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("users", usersRepository.findAll());
        return "dictionaries";
    }

}