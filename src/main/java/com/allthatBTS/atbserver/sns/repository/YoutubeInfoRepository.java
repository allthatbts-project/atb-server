package com.allthatBTS.atbserver.sns.repository;

import com.allthatBTS.atbserver.sns.domain.YoutubeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YoutubeInfoRepository extends JpaRepository<YoutubeInfo, String> {
    List<YoutubeInfo> findFirst10ByOrderByUpdateDtDesc();
}
