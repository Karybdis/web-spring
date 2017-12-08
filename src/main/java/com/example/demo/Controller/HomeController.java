package com.example.demo.Controller;

import com.example.demo.Entity.Match;
import com.example.demo.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
public class HomeController
{
    @Autowired
    private MatchRepository matchRepository;

    @RequestMapping("/home")
    public  String home(Model model)
    {
        ArrayList<Match> matchlist=(ArrayList<Match>) matchRepository.findAll();  //获取所有比赛
        model.addAttribute("matchlist",matchlist);
        return "home";
    }

}
