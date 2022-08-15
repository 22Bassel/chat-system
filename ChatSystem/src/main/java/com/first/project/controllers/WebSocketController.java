package com.first.project.controllers;

import com.first.project.User;
import com.first.project.model.UsersRepository;
import com.first.project.model.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketController {


    @Autowired
    private UsersRepository users_repository;



    @RequestMapping("/chatPage")
    public String getWebSocket(Model model, @RequestParam String username)
    {

        model.addAttribute("username", username);
        users_repository.save(new UsersTable(username));

        return "ws-broadcast";
    }

    @GetMapping("/")
    public String home(Model model, HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");

        if(username!=null) {
            Integer id=users_repository.GetByName(username);
            if(id==null){
            model.addAttribute("username", username);
            return "redirect:/chatPage?username="+username;
        }
        else {

                String errorMsg="UserName is token";
                //ErrorMessage errorMessage=new ErrorMessage(new Throwable(errorMsg));
                model.addAttribute("errorForm",errorMsg);
                return "login";
            }
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/")
    public String homePost(Model model,@ModelAttribute User user, HttpSession httpSession) {

        if(!user.getUsername().isEmpty()) {

            Integer id=users_repository.GetByName(user.getUsername());

            if(id==null){

                httpSession.setAttribute("username", user.getUsername());


                return "redirect:/chatPage?username="+user.getUsername();
            }
            else {

                String errorMsg="UserName is token";

                model.addAttribute("errorForm",errorMsg);
                return "login";
                }
        }else {

            return "login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");
        if(username!=null) {
            httpSession.removeAttribute("username");
            users_repository.DeleteByName(username);
        }

        return "redirect:/";
    }

}