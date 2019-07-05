package com.allthatBTS.atbserver.sns.repository;

import com.allthatBTS.atbserver.sns.domain.TwitterInfo;
import com.allthatBTS.atbserver.sns.domain.YoutubeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TwitterInfoRepository extends JpaRepository<TwitterInfo, String> {
    List<TwitterInfo> findFirst100ByOrderByUpdateDtDesc();
}
