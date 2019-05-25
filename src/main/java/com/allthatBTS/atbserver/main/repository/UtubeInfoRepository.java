package com.allthatBTS.atbserver.main.repository;

import com.allthatBTS.atbserver.main.domain.UtubeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtubeInfoRepository extends JpaRepository<UtubeInfo, String> {
    List<UtubeInfo> findFirst10ByOrderByUpdateDtDesc();
}
