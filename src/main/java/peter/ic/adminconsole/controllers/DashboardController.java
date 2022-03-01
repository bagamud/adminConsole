package peter.ic.adminconsole.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.*;
import peter.ic.adminconsole.service.TurtlePostman;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    final TurtlePostman turtlePostman;
    final DepartmentRepository departmentRepository;
    final PositionRepository positionRepository;
    final ServicesRepository servicesRepository;
    final RankRepository rankRepository;
    final StaffRepository staffRepository;
    final RolesRepository rolesRepository;
    final UsersRepository usersRepository;
    final GenderRepository genderRepository;

    public DashboardController(TurtlePostman turtlePostman, DepartmentRepository departmentRepository, PositionRepository positionRepository, ServicesRepository servicesRepository, RankRepository rankRepository, StaffRepository staffRepository, RolesRepository rolesRepository, UsersRepository usersRepository, GenderRepository genderRepository) {
        this.turtlePostman = turtlePostman;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.servicesRepository = servicesRepository;
        this.rankRepository = rankRepository;
        this.staffRepository = staffRepository;
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
        this.genderRepository = genderRepository;
    }

    @GetMapping()
    public String staff(@RequestParam(defaultValue = "") String filter, Model model) {
        serviceDictionaries(model);
        if (!filter.equals("")) {
            String[] filterParam = filter.split("\\.");
            String type = filterParam[0];
            String value = filterParam[1];
            switch (type) {
                case "username":
                    model.addAttribute("staffList", staffRepository.findAllByUsername(value));
                    break;
                case "lastName":
                    model.addAttribute("staffList", staffRepository.findAllByLastName(value));
                    break;
                case "post":
                    model.addAttribute("staffList", staffRepository.findAllByPosition_Code(Integer.parseInt(value)));
                    break;
                case "department":
                    model.addAttribute("staffList", staffRepository.findAllByDepartment_Code(Integer.parseInt(value)));
                    break;
                case "active":
                    model.addAttribute("staffList", staffRepository.findAllByStatus_Id(Integer.parseInt(value)));
                    break;
                default:
                    break;
            }
        } else {
            model.addAttribute("staffList", usersRepository.findAll());
        }

        return "dashboard";
    }

    private void serviceDictionaries(Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);

        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("post", positionRepository.findAll());
        model.addAttribute("services", servicesRepository.findAll());
        model.addAttribute("rank", rankRepository.findAll());
        model.addAttribute("roles", rolesRepository.findAll());
    }


    private Users getAuthorizedUser() {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersRepository.findByUsername(userAuth.getUsername());
    }
}