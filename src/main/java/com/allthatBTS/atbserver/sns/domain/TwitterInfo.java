package com.allthatBTS.atbserver.sns.domain;

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
@Table(name = "tb_twitter_data")
public class TwitterInfo implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String twitterId;

    @Column
    private String accountName;

    @Column
    private String tweetText;

    @Column
    private String hashtags;

    @Column
    private int retweetCnt;

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
