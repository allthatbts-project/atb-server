package com.allthatBTS.atbserver.crawling;

import com.allthatBTS.atbserver.crawling.domain.TwitterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterDataRepository extends JpaRepository<TwitterData, Long> {
    //List<YoutubeData> findYoutubeDataList(int pageNo,
    //                                      int pageSize,
    //                                      String orderCondition,
    //                                      String orderType);
}
