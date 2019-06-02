package com.allthatBTS.atbserver.crawling;

import com.allthatBTS.atbserver.crawling.domain.YoutubeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YoutubeDataRepository extends JpaRepository<YoutubeData, Long> {
    //List<YoutubeData> findYoutubeDataList(int pageNo,
    //                                      int pageSize,
    //                                      String orderCondition,
    //                                      String orderType);
}
