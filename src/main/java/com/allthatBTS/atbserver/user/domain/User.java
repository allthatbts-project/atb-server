package com.allthatBTS.atbserver.user.domain;

import com.allthatBTS.atbserver.user.domain.enums.RoleType;
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
@Table(name = "tb_user")
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

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @Transient
    private Map<String, Object> attributes;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, String imageUrl, SocialType socialType, String socialId, Role role, Map<String, Object> attributes, LocalDateTime createdDate, LocalDateTime updatedDate){
        this.name = name;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
        this.socialType = socialType;
        this.socialId = socialId;
        this.role = role;
        this.attributes = attributes;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public User(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.imageUrl = user.getImageUrl();
        this.socialType = user.getSocialType();
        this.socialId = user.getSocialId();
        this.role = user.getRole();
        this.createdDate = user.getCreatedDate();
        this.updatedDate = user.getUpdatedDate();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
