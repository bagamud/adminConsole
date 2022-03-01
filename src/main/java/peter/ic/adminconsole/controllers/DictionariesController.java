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
    final DepartmentRepository departmentRepository;
    final PositionRepository positionRepository;
    final ServicesRepository servicesRepository;
    final RankRepository rankRepository;
    final RolesRepository rolesRepository;
    final UsersRepository usersRepository;

    public DictionariesController(DepartmentRepository departmentRepository, PositionRepository positionRepository, ServicesRepository servicesRepository, RankRepository rankRepository, RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
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
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("post", positionRepository.findAll());
        model.addAttribute("services", servicesRepository.findAll());
        model.addAttribute("rank", rankRepository.findAll());
        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("users", usersRepository.findAll());
        return "dictionaries";
    }

}