package com.assignment.DonationApp.controllers;

import com.assignment.DonationApp.Donation;
import com.assignment.DonationApp.services.DocumentService;
import com.assignment.DonationApp.services.DocumentServiceIml;
import com.assignment.DonationApp.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private DonationService service;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private DocumentServiceIml documentServiceIml;


    @RequestMapping("/")
    public String viewHomePage(Model model){

        List<Donation> donationList = service.listAll();
        model.addAttribute("donationList",donationList);

        return "homePage";

    }

    @RequestMapping("/donationPage.html")
    public String showDonationPage(Model model){

            Donation donation = new Donation();
            model.addAttribute("donation",donation);

            return "donationPage";

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String submitDonation(@ModelAttribute("donation")Donation donation,Model model){

        List<Donation> donationList = service.listAll();
        model.addAttribute("donationList",donationList);
        service.save(donation);

        return "dataPage";

    }
    @RequestMapping(value = "/dataPage.html",method = RequestMethod.GET)
    public String displayData(Model model){

        List<Donation> donationList = service.listAll();
        model.addAttribute("donationList",donationList);


        return "dataPage";
    }


}
