package com.allthatBTS.atbserver.user.domain;

import com.allthatBTS.atbserver.user.domain.enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    //@NaturalId
    @Column(length = 60)
    private RoleType name;

    public Role() {

    }

    public Role(RoleType name) {
        this.name = name;
    }
}
