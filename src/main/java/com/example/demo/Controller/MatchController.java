package com.example.demo.Controller;

import com.example.demo.Entity.Match;
import com.example.demo.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatchController
{
    @Autowired
    private MatchRepository matchRepository;

    @PostMapping("/addmatch")
    public  String  addmatch(@RequestParam String match_name, @RequestParam String information)
    {
        Match match=new Match();
        match.setMatch_name(match_name);
        match.setInformation(information);
        matchRepository.save(match);
        return "redirect:/home";
    }
    @RequestMapping("/delmatch")
    public String delmatch(@RequestParam Long id)
    {
        if (matchRepository.findOne(id)!=null)
            matchRepository.delete(id);
        return "redirect:/home";
    }
}
