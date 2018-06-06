package com.ongo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminProfileController {

    @RequestMapping(value = "/profile")
    public String getAdminDashboard(Model model) {
        return "/dashboard/profile";
    }
}
