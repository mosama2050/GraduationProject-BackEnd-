package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "regular_term_rules")
public class RegularTermRules extends BaseEntity{

    @Column(name = "gpa_low")
    private int gpaLow;

    @Column(name = "gpa_high")
    private int gpaHigh;


    @Column(name = "hour_min")
    private int hourMin;

    @Column(name = "hour_max")
    private int hourMax;

    @Column(name = "hour_sp_min")
    private int hourSpMin;

    @Column(name = "hour_sp_max")
    private int hourSpMax;

}
