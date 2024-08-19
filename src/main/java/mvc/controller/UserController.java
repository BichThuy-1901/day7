package mvc.controller;

import mvc.formregistration.Gender;
import mvc.formregistration.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {
    private static final String[] countries = {"Vietnam", "United States", "Germany"};

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries", countries);
        return "formregistration/userForm";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String processUser(@ModelAttribute("user") User user) {
        return "formregistration/userResult";
    }
}
