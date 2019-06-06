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
@Table(name = "tb_instagram_data")
public class InstagramData implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String instagramId;

    @Column
    private String userName;

    @Column
    private String imageUrl;

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
