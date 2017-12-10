package com.example.demo.Controller;

import com.example.demo.Entity.Contest;
import com.example.demo.Repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
public class HomeController
{
    @Autowired
    private ContestRepository contestRepository;

    @RequestMapping("/home")
    public  String home(Model model)
    {
        ArrayList<Contest> contestlist=(ArrayList<Contest>) contestRepository.findAll();  //获取所有比赛
        model.addAttribute("contestlist",contestlist);
        return "home";
    }
}
