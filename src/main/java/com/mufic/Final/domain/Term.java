package com.mufic.Final.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
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
@Table(name = "Term")
public class Term extends BaseEntity {


    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Term_type")
    private TermType termType;

    @Column(name = "start_at")
//    @Temporal(TemporalType.DATE)
    private LocalDate start;

    @Column(name = "end_at")
//    @Temporal(TemporalType.DATE)
    private LocalDate end;

    @Column(name = "start_registration")
//    @Temporal(TemporalType.DATE)
    private LocalDate startRegistration;

    @Column(name = "end_registration")
//    @Temporal(TemporalType.DATE)
    private LocalDate endRegistration;

    @Column(name = "start_updating")
//    @Temporal(TemporalType.DATE)
    private LocalDate startUpdating;

    @Column(name = "end_updating")
//    @Temporal(TemporalType.DATE)
    private LocalDate endUpdating;

    @Column(name = "start_withdrawn")
//    @Temporal(TemporalType.DATE)
    private LocalDate startWithdrawn;

    @Column(name = "end_withdrawn")
//    @Temporal(TemporalType.DATE)
    private LocalDate endWithdrawn;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDate createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private LocalDate updateTime;

    @OneToMany(mappedBy = "term")
    List<CourseInTerm> courseInTermList;

    @OneToMany(mappedBy = "term")
    List<Transaction> transactions;

    @ManyToMany(mappedBy = "terms")
    List<Student> students;
    

}
