package com.github.pengpan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pengpan.entity.User;
import com.github.pengpan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, String name, String password) throws Exception {
        HttpSession session = request.getSession();
        Assert.notNull(name, "name is required");
        Assert.notNull(password, "password is required");
        User user = userService.findByName(name);
        Assert.notNull(user, "user not exist");
        if (password.equals(user.getPassword())) {
            ObjectMapper objectMapper = new ObjectMapper();
            session.setAttribute("user", objectMapper.writeValueAsString(user));
            return "login success!" + "<br>"
                    + "session_id: " + session.getId() + "<br>"
                    + "user: " + session.getAttribute("user");
        }
        return "login failed!";
    }
}
