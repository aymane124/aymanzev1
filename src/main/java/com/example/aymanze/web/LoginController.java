package com.example.aymanze.web;
import ch.qos.logback.core.model.Model;
import com.example.aymanze.dao.entities.Pharmacy;
import com.example.aymanze.dao.repositories.PharmacyRepository;
import com.example.aymanze.metier.manager.PharmacyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

        @Autowired
        private PharmacyManager pharmacyManager;
        @Autowired
        private PharmacyRepository pharmacyRepository;


        @GetMapping("/login")
        public String login() {
            return "login";
        }

        @GetMapping("/register")
        public String register() {
            return "register";
        }



    @PostMapping("/checklogin")
    public String checkLogin(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        boolean isAuthenticated = pharmacyManager.authenticate(email, password);

        if (isAuthenticated) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }


    @PostMapping("/register")
    public String registerPharmacy(@ModelAttribute Pharmacy pharmacy,
                                   @RequestParam("confirm_password") String confirmPassword,
                                   Model model) {
        // Check if passwords match
        if (!pharmacy.getPassword().equals(confirmPassword)) {

            return "register"; // Return to registration form with error message
        }

        // Check if email is already registered
        if (pharmacyRepository.findPharmacyByEmail(pharmacy.getEmail()) != null) {

            return "register"; // Return to registration form with error message
        }

        // Save the pharmacy to the repository
        pharmacyRepository.save(pharmacy);

        // Redirect to a success page or login page
        return "redirect:/login";
    }


}


