package com.allthatBTS.atbserver.main;

import com.allthatBTS.atbserver.main.domain.UtubeInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/main")
public class MainController {
    private final MainService mainService;

    MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/utube")
    public ResponseEntity<UtubeInfo> getUtubeInfoList(){
        //String bearerToken = request.getHeader("Authorization");
        ResponseEntity result = new ResponseEntity(mainService.getUtubeInfoList(), HttpStatus.OK);
        return result;
    }
}
