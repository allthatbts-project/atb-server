package com.allthatBTS.atbserver.crawling.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_youtube_data")
public class YoutubeData implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String youtubeId;

    @Column
    private String channelName;

    @Column
    private String title;

    @Column
    private String thumbnailImgUrl;

    @Column
    private int viewCnt;

    @Column
    private int likeCnt;

    @Column
    private int dislikeCnt;

    @Column
    private int commentCnt;

    @Column
    private LocalDateTime publishDt;

    @Column
    private String url;

    @Column
    private char deletedYn;

    @Column
    private LocalDateTime deletedDt;

    @Column
    private LocalDateTime createDt;

    @Column
    private LocalDateTime updateDt;
}
