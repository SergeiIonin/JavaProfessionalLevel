package com.senin26.controller;

import com.senin26.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.senin26.service.EmployeeService;

/**
 * Rewritten by <a href="mailto:sergey.ionin.7@gmail.com">Sergey Ionin</a><br/>
 * based on the project of
 * <a href="mailto:izebit@gmail.com">Artem Konovalov</a> at <a href=https://github.com/izebit/spring-web-demo></a><br/>
 * Creation date: 1/7/18.
 * @since 1.0
 */
@Controller
@RequestMapping("/blog")
public class MainController {

    @Autowired
    private EmployeeService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("employees", service.getAll());
        return "main";
    }

    @RequestMapping(value = "/addition")
    public String editorPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "addition";
    }

    @RequestMapping(value = "/addition/submit", method = RequestMethod.POST)
    public String submitEmployee(@ModelAttribute Employee employee) {
        service.save(employee);
        return "redirect:../";
    }

    @RequestMapping(value = "/delete/{employee_id}")
    public String deleteEmployee(@PathVariable("employee_id") Integer employeeId, Model model) {
        model.addAttribute("employees", service.delete(employeeId));
        return "redirect:../";
    }

}
