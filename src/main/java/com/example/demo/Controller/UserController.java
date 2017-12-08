package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserInfo;
import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;   //存储账号密码
    @Autowired
    private UserInfoRepository userInfoRepository;  //存储其他信息

    @GetMapping("/signup")
    public String signup()
    {
        return "sign_up";
    }

    @PostMapping("/signup")   //用户注册
    public  String adduser(@RequestParam String username,@RequestParam String password,@RequestParam String role,@RequestParam String qq,@RequestParam String email)
    {
        User user=new User();
        UserInfo userInfo=new UserInfo();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);          //名字
        user.setAdmin(0);            //非管理员标记
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

    @PostMapping("/login")   //用户登录
    public String userlogin(@RequestParam String username, @RequestParam String password, HttpSession session)
    {
        if (userRepository.findByUsername(username)!=null)   //存在该用户
        {
            String exist_username = userRepository.findByUsername(username).getUsername();
            String exist_password = userRepository.findByUsername(username).getPassword();
            if (username.equals(exist_username) && password.equals(exist_password))   //输入的账号密码与数据库已有数据一样
            {
                session.setAttribute("user",userRepository.findByUsername(username));   //添加session
                session.setAttribute("role",userRepository.findByUsername(username).getRole());
                session.setAttribute("admin",userRepository.findByUsername(username).getAdmin());
                return "redirect:/home";
            }
            else return "login";
        }
        else return "login";
    }
    @GetMapping("/logout")  //登出
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");   //移除session
        session.removeAttribute("role");
        session.removeAttribute("admin");
        return "login";
    }

    @GetMapping("/userinfo")
    public String userinfo(Model model,HttpSession session)
    {
        UserInfo userInfo=userInfoRepository.findByRole((String)session.getAttribute("role"));
        model.addAttribute("userinfo",userInfo);
        return "user_info";
    }



//    @RequestParam("/edituser")
//    public String edituser()
//    {
//
//    }
}
