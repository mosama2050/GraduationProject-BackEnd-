package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "Student")
public class Student extends BaseEntity {

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

    @Column(name = "Guardian_name")
    String guardianName;

    @Column(name = "Guardian_job")
    String GuardianJob;

    @Column(name = "email")
    String email;

    @Column(name = "sec_school")
    String secSchool;

    @Column(name = "pre_qualfication")
    String preQualfication;

    @Column(name = "quilification_year")
    @Temporal(TemporalType.DATE)
    Date QuilificationYear;

    @Column(name="degrees")
    double degrees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="guide_id")
    TeachingStaff guide;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_info_id")
    StudentInfo studentInfo;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;


    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<StudentHasCourseInTerm> studentHasCourseInTerms;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<Transaction> transactions;



    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "Student_in_Term",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "term_id")
            )
    List<Term> terms;



}
