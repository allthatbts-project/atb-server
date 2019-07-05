package com.allthatBTS.atbserver.sns;

import com.allthatBTS.atbserver.sns.domain.YoutubeInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sns")
public class SnsController {
    private final SnsService snsService;

    SnsController(SnsService snsService){
        this.snsService = snsService;
    }

    @GetMapping("/youtube")
    public ResponseEntity<YoutubeInfo> getYoutubeInfoList(){
        //String bearerToken = request.getHeader("Authorization");
        ResponseEntity result = new ResponseEntity(snsService.getYoutubeInfoList(), HttpStatus.OK);
        return result;
    }

    @GetMapping("/twitter")
    public ResponseEntity<YoutubeInfo> getTwitterInfoList(){
        ResponseEntity result = new ResponseEntity(snsService.getTwitterInfoList(), HttpStatus.OK);
        return result;
    }
}

