package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled")
    boolean enabled;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_roles",
        joinColumns = @JoinColumn(name="users_id"),
        inverseJoinColumns = @JoinColumn(name="roles_id"))
    private Set<Role> roles;

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//    TeachingStaff teachingStaff;
//
//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//    Student student;


}
