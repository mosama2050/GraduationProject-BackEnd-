package com.mufic.Final.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "Student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Term_id")
    private Term term;

    @Column(name = "course_cnt")
    private int courseCnt;

    @Column(name = "total")
    private double total;

    @Column(name = "bill_no")
    private int billNo;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

}
