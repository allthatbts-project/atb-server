package com.allthatBTS.atbserver.controller;

import com.allthatBTS.atbserver.annotation.SocialUser;
import com.allthatBTS.atbserver.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login/oauth2/code/**")
    public String loginComplete2(@SocialUser User user, Model model){
        model.addAttribute("socialInfo", user);
        return "result";
    }

//    @GetMapping(value = "/{facebook|google|kakao}/complete")
//    public String loginComplete(HttpSession httpSession){
//        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
//        Map<String, String> map = (HashMap<String, String>)authentication.getUserAuthentication().getDetails();
//        httpSession.setAttribute("user", User.builder()
//                .name(map.get("name"))
//                .email(map.get("email"))
//                .principal(map.get("id"))
//                .socialType(SocialType.FACEBOOK)
//                .createdDate(LocalDateTime.now())
//                .build());
//        return "redirect:/board/list";
//    }
}
