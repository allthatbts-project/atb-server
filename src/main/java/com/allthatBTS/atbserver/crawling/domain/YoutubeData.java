package com.allthatBTS.atbserver.crawling.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
@Table
public class YoutubeData implements Serializable
{
    @Id
    @Column(name = "ID")
    private String Id;

    @Column(name = "YOUTUBE_ID")
    private String YoutubeId;

    @Column(name = "CHANNEL_NAME")
    private String ChannelName;

    @Column(name = "TITLE")
    private String Title;

    @Column(name = "THUMBNAIL_IMG_URL")
    private String ThumbnailImageUrl;

    @Column(name = "VIEW_CNT")
    private Long ViewCount;

    @Column(name = "LIKE_CNT")
    private Long LikeCount;

    @Column(name = "DISLIKE_CNT")
    private Long DislikeCount;

    @Column(name = "COMMENT_CNT")
    private Long CommentCount;

    @Column(name = "PUBLISH_DT")
    private LocalDateTime PublishDatetime;

    @Column(name = "URL")
    private String Url;

    @Column(name = "DELETED_YN")
    private String DeleteYN;

    @Column(name = "DELETED_DT")
    private LocalDateTime DeletedDateTime;

    @Column(name = "CREATE_DT")
    private LocalDateTime CreateDateTime;

    @Column(name = "UPDATE_DT")
    private LocalDateTime UpdateDateTime;

}
