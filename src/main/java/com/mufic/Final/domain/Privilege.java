package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "privileges")
public class Privilege extends BaseEntity{

//    @Builder
/*    public Privilege(Long id,String name, Date createTime, Date updateTime, Set<Role> users) {
        super(id);
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.users = users;
    }*/
    @Column(name = "name")
    @Enumerated(value = EnumType.STRING)
    private EPrivilege name;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;


}
