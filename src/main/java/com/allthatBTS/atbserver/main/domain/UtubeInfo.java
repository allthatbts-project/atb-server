package com.allthatBTS.atbserver.main.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "tb_youtube_data")
@Entity
public class UtubeInfo {
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
