package com.allthatBTS.atbserver.sns;

import com.allthatBTS.atbserver.sns.domain.TwitterInfo;
import com.allthatBTS.atbserver.sns.domain.YoutubeInfo;
import com.allthatBTS.atbserver.sns.repository.TwitterInfoRepository;
import com.allthatBTS.atbserver.sns.repository.YoutubeInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnsService {

    private final YoutubeInfoRepository youtubeInfoRepository;
    private final TwitterInfoRepository twitterInfoRepository;

    SnsService(YoutubeInfoRepository youtubeInfoRepository, TwitterInfoRepository twitterInfoRepository){
        this.youtubeInfoRepository = youtubeInfoRepository;
        this.twitterInfoRepository = twitterInfoRepository;
    }

    public List<YoutubeInfo> getYoutubeInfoList(){
        return youtubeInfoRepository.findFirst10ByOrderByUpdateDtDesc();
    }

    public List<TwitterInfo> getTwitterInfoList() { return twitterInfoRepository.findFirst100ByOrderByUpdateDtDesc(); }
}
