package com.allthatBTS.atbserver.user.domain;

import com.allthatBTS.atbserver.user.domain.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class User implements UserDetails, OAuth2User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String imageUrl;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    private String socialId;

    @Transient
    private Map<String, Object> attributes;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, String imageUrl, SocialType socialType, String socialId, Map<String, Object> attributes, LocalDateTime createdDate, LocalDateTime updatedDate){
        this.name = name;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
        this.socialType = socialType;
        this.socialId = socialId;
        this.attributes = attributes;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

//    public static User create(User user) {
//        List<GrantedAuthority> authorities = Collections.
//                singletonList(new SimpleGrantedAuthority("ROLE_USER"));
//
//        return new User(
//                user.getId(),
//                user.getEmail(),
//                user.getPassword(),
//                authorities
//        );
//    }
//
//    public static User create(User user, Map<String, Object> attributes) {
//        User resultUser = User.create(user);
//        resultUser.setAttributes(attributes);
//        return resultUser;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
