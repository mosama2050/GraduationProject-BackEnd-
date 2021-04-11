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
//@ToString
@Builder
@Entity
@Table(name="Teaching_staff")
public class TeachingStaff extends BaseEntity{

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Column(name = "nationality")
    String nationality;

    @Column(name = "gender")
    @Enumerated(value = EnumType.ORDINAL)
    Gender gender;

    @Column(name = "Religion")
    String religion;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    Date DOB;

    @Column(name = "national_id")
    String nationalId;

    @Column(name = "email")
    String email;

    @Column(name = "PHD_degree")
    String phdDegree;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    User user;


    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    List<CourseInTerm> courseInTermList;

    @OneToMany(mappedBy = "teachingStaff", fetch = FetchType.LAZY)
    List<Labs> labs;

    @OneToMany(mappedBy ="guide", fetch = FetchType.LAZY)
    List<Student> students;

}
