package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserInfo;
import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/signup")
    public String signup()
    {
        return "sign_up";
    }

    @PostMapping("/signup")
    public  String adduser(@RequestParam String username,@RequestParam String password,@RequestParam String role,@RequestParam String qq,@RequestParam String email)
    {
        User user=new User();
        UserInfo userInfo=new UserInfo();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setAdmin(0);
        userInfo.setRole(role);
        userInfo.setQq(qq);
        userInfo.setEmail(email);
        userRepository.save(user);
        userInfoRepository.save(userInfo);
        return "login";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")
    public String userlogin(@RequestParam String username, @RequestParam String password, HttpSession session)
    {
        if (userRepository.findByUsername(username)!=null)
        {
            String exist_username = userRepository.findByUsername(username).getUsername();
            String exist_password = userRepository.findByUsername(username).getPassword();
            if (username.equals(exist_username) && password.equals(exist_password))
            {
                session.setAttribute("user",userRepository.findByUsername(username));
                session.setAttribute("role",userRepository.findByUsername(username).getRole());
                session.setAttribute("admin",userRepository.findByUsername(username).getAdmin());
                return "redirect:/home";
            }
            else return "login";
        }
        else return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        session.removeAttribute("role");
        session.removeAttribute("admin");
        return "login";
    }
}
