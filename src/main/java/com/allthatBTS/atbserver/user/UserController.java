package com.allthatBTS.atbserver.user;

import com.allthatBTS.atbserver.user.domain.annotation.SocialUser;
import com.allthatBTS.atbserver.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //@GetMapping("/login/oauth2/code/**")
        public String loginComplete(@SocialUser User user, HttpServletResponse response) throws IOException {
            //model.addAttribute("socialInfo", user);

//        Cookie cookie = new Cookie("jwtToken", jwtTokenProvider.generateToken(user));
//        cookie.setPath("/");
//        cookie.setMaxAge(60 * 60 * 24);
//        response.addCookie(cookie);
        //response.sendRedirect("127.0.0.1:3000");
        return "redirect:localhost:3000";
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
