package com.allthatBTS.atbserver.crawling;

import com.allthatBTS.atbserver.crawling.domain.InstagramData;
import com.allthatBTS.atbserver.crawling.domain.YoutubeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstagramDataRepository extends JpaRepository<InstagramData, Long> {
    //List<YoutubeData> findYoutubeDataList(int pageNo,
    //                                      int pageSize,
    //                                      String orderCondition,
    //                                      String orderType);
}
