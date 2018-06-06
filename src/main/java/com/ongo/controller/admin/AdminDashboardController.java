package com.ongo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminDashboardController {

    @RequestMapping(value = "/dashboard")
    public String getAdminDashboard(Model model) {
        return "/dashboard/index";
    }
}
