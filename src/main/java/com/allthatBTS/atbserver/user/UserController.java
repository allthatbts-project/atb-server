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


}
