package com.allthatBTS.atbserver.crawling;

import com.allthatBTS.atbserver.crawling.domain.InstagramData;
import com.allthatBTS.atbserver.crawling.domain.TwitterData;
import com.allthatBTS.atbserver.crawling.domain.YoutubeData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@Api(tags = "crawler")
public class CrawlingController {
    @Autowired
    YoutubeDataRepository youtubeDataRepository;

    @Autowired
    TwitterDataRepository twitterDataRepository;

    @Autowired
    InstagramDataRepository instagramDataRepository;

    @ApiOperation("Retrieves a Youtube DataList.")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "YoutubeData not found."),
            @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(method = RequestMethod.POST, value = "/api/crawler/YoutubeDataList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getYoutubeDataList(){
        Map result = new HashMap();
        List<YoutubeData> youtubeDataList = youtubeDataRepository.findAll();
        result.put("youtubeData", youtubeDataList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("Retrieves a Twitter DataList.")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "TwitterData not found."),
            @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(method = RequestMethod.POST, value = "/api/crawler/TwitterDataList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTwitterDataList(){
        Map result = new HashMap();
        List<TwitterData> twitterDataList = twitterDataRepository.findAll();
        result.put("twitterData", twitterDataList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("Retrieves a Youtube DataList.")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "YoutubeData not found."),
            @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(method = RequestMethod.POST, value = "/api/crawler/InstagramDataList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInstagramDataList(){
        Map result = new HashMap();
        List<InstagramData> instagramDataList = instagramDataRepository.findAll();
        result.put("instagramData", instagramDataList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
