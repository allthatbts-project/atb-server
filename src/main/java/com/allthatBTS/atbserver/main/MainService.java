package com.allthatBTS.atbserver.main;

import com.allthatBTS.atbserver.main.domain.UtubeInfo;
import com.allthatBTS.atbserver.main.repository.UtubeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final UtubeInfoRepository utubeInfoRepository;

    MainService(UtubeInfoRepository utubeInfoRepository){
        this.utubeInfoRepository = utubeInfoRepository;
    }

    public List<UtubeInfo> getUtubeInfoList(){
        return utubeInfoRepository.findFirst10ByOrderByUpdateDtDesc();
    }
}
