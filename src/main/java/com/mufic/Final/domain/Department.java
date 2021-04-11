package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "department")
public class Department extends BaseEntity{

    @Column(name = "name_English")
    private String nameEnglish;

    @Column(name="name_Arabic")
    private String nameArabic;

    @Column(name = "code")
    private String code;

    @Column(name = "Graduation_Project_hours")
    private int graduationProjectHours;

    @Column(name = "Graduation_hours")
    private int graduationHours;

    @Column(name = "min_terms")
    private int minTerms;

    @Column(name = "max_degree_on_fail")
    private int maxDegreeOnFail;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Student> students;


}
