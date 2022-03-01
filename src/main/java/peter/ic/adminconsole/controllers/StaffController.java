package peter.ic.adminconsole.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peter.ic.adminconsole.entity.Staff;
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.*;

@Controller
@RequestMapping("/profile")
public class StaffController {
    final StaffRepository staffRepository;
    final GenderRepository genderRepository;
    final PositionRepository positionRepository;
    final StatusRepository statusRepository;
    final RankRepository rankRepository;
    final DepartmentRepository departmentRepository;
    final UsersRepository usersRepository;

    public StaffController(StaffRepository staffRepository,
                           GenderRepository genderRepository, PositionRepository positionRepository,
                           StatusRepository statusRepository, RankRepository rankRepository,
                           DepartmentRepository departmentRepository,
                           UsersRepository usersRepository) {
        this.staffRepository = staffRepository;
        this.genderRepository = genderRepository;
        this.positionRepository = positionRepository;
        this.statusRepository = statusRepository;
        this.rankRepository = rankRepository;
        this.departmentRepository = departmentRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping("")
    public String getCard(@RequestParam(defaultValue = "0") int staffId, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionaries(model);

        try {
            Staff staff = staffRepository.findByStaffId(staffId);
//            if (user.getDepartment().getCode() == staff.getDepartment().getCode()
//                    || inheritanceOfDepartmentsRepository.findInheritance(user.getDepartment().getCode()).contains(staff.getDepartment().getCode())) {
            model.addAttribute("staffProfile", staff);
//            }
        } catch (Exception e) {
            model.addAttribute("errors", e.getMessage());
        }

        return "profile";
    }

    @PostMapping("/add")
    public String addCard(Staff staff, BindingResult bindingResult, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);

        dictionaries(model);

        try {
//            if (user.getDepartment().getCode() == staff.getDepartment().getCode()
//                    || inheritanceOfDepartmentsRepository.findInheritance(user.getDepartment().getCode()).contains(staff.getDepartment().getCode())) {
            model.addAttribute("staffProfile", staffRepository.save(staff));
            model.addAttribute("resultMessage", "Карточка успешно сохранена");
//            }
        } catch (Exception e) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("bindingResult", bindingResult);
            }
            model.addAttribute("errors", e.getMessage());
        }
        return "profile";
    }

    public void dictionaries(Model model) {
        model.addAttribute("gender", genderRepository.findAll());
        model.addAttribute("position", positionRepository.findAll());
        model.addAttribute("rank", rankRepository.findAll());
        model.addAttribute("department", departmentRepository.findAllByActiveIsTrueOrderByCode());
        model.addAttribute("departmentRoot", departmentRepository.findAllByActiveIsTrueAndAnchor_NameOrderByCode("root"));
        model.addAttribute("status", statusRepository.findAll());
    }
}
