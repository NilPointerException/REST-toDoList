package com.todo.controller;

import com.todo.service.MailService;
import com.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WebController {

    @Autowired
    TaskService taskService;

    @Autowired
    MailService mailService;

    @GetMapping("/todo")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("tasks", taskService.getAllTasks());

        return "welcome"; //view
    }

    @GetMapping("/theball")
    public String theBall(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("name", name);

        return "theBall"; //view
    }

    @GetMapping("/")
    public String contactme(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("name", name);

        return "contactme"; //view
    }

    @GetMapping("/countdown")
    public String countdown(){
        return "countdown"; //view
    }

    @PostMapping(value = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMail(
            @RequestBody String name, String email, String message) {

        mailService.sendEmail(name, message);
    }
}
