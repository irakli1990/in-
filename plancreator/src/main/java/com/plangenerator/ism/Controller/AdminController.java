package com.plangenerator.ism.Controller;


import com.plangenerator.ism.Model.Department;
import com.plangenerator.ism.Repository.DepartmentRepository;
import com.plangenerator.ism.Repository.UserRepository;
import com.plangenerator.ism.Service.DepartmentService;
import com.plangenerator.ism.Service.MinimumService;
import com.plangenerator.ism.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Irakli Kardava
 */
@Controller("adminController")
public class AdminController {

    @Autowired
    private UserServiceImpl userServiceimpl;

    @Autowired
    private MinimumService minimumService;

    @Autowired
    private DepartmentService depatmentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    /**
     * @param model
     * @param department
     * @return template with model and attribute "admin/department"
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = {"/department"})
    public String department(Model model, Department department) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("user", userDetail.getUsername());
            model.addAttribute("list", depatmentService.getDepartmentList());
            model.addAttribute("departmentCounter", depatmentService.countDepartment() + " Wydziałów");

        }
        return "admin/department";
    }

    /**
     * @param model
     * @return template with model and attribute "admin/welcome"
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/welcome")
    public String ShowUserDetails(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("user", userDetail.getUsername());
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("min", minimumService.getMinimumList());
            model.addAttribute("usercout", userServiceimpl.countUser() + " uzitkowników zarejstrowanich");
        }
        return "admin/welcome";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/minimum")
    public ModelAndView showMinimum() {
        ModelAndView modelAndView = new ModelAndView("/admin/minimum");
        modelAndView.addObject("minimum", minimumService.getMinimumList());
        modelAndView.addObject("mincount", minimumService.countPlan() + " liczebnosc prograu minimum");
        modelAndView.addObject("depcout", depatmentService.countDepartment() + " Wydziału");
        modelAndView.addObject("usercout", userServiceimpl.countUser() + " uzitkowników zarejstrowanich");
        return modelAndView;
    }


}
