package com.example.demo.Controller;

import com.example.demo.Entity.Contest;
import com.example.demo.Entity.ContestTag;
import com.example.demo.Entity.Tag;
import com.example.demo.Repository.ContestRepository;
import com.example.demo.Repository.ContestTagRepository;
import com.example.demo.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ContestController
{
    @Autowired
    private ContestRepository contestRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ContestTagRepository contestTagRepository;

    @PostMapping("/addcontest")  //添加比赛
    public  String  addcontest(@RequestParam String contestName, @RequestParam String information, @RequestParam ArrayList<String> tags, HttpSession session)
    {
        if ((int)session.getAttribute("admin")==1)  //管理员判定
        {
            Contest contest = new Contest();
            contest.setContestName(contestName);
            contest.setInformation(information);
            contestRepository.save(contest);
            for (String tagName:tags)
            {
                Tag tag=new Tag();
                ContestTag contestTag=new ContestTag();
                contestTag.setContestId(contestRepository.findByContestName(contestName).getId());
                tag.setTagName(tagName);
                tagRepository.save(tag);
                contestTag.setTagId(tagRepository.findByTagName(tagName).getId());
                contestTagRepository.save(contestTag);
            }
        }
        return "redirect:/home";
    }

    @RequestMapping("/delcontest")    //删除比赛
    public String delcontest(@RequestParam Long id, HttpSession session)
    {
        if ((int)session.getAttribute("admin")==1)  //管理员判定
        {
            if (contestRepository.findOne(id) != null)    //该ID的比赛存在则删除
                contestRepository.delete(id);
        }
        return "redirect:/home";
    }
}

