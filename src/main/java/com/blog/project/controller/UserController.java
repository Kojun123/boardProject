package com.blog.project.controller;


import com.blog.project.dto.user.UserCreateForm;
import com.blog.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm){
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){ // 비밀번호와 비밀번호 확인이 서로 일치하지 않는다면
            bindingResult.rejectValue("password2","passwordInCorrect","패스워드가 일치하지 않습니다.");
            return "user/signup";
        }

        userService.createUser(userCreateForm.getUserName(),userCreateForm.getEmail(),userCreateForm.getPassword1());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
}
