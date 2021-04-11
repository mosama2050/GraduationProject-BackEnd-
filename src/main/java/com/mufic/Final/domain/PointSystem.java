package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "point_system")
public class PointSystem extends BaseEntity{

//    @Builder
/*    public PointSystem(Long id, String nameEnglish, String nameArabic, int degreeLow, int degreeHigh, double points) {
        super(id);
        this.nameEnglish = nameEnglish;
        this.nameArabic = nameArabic;
        this.degreeLow = degreeLow;
        this.degreeHigh = degreeHigh;
        this.points = points;
    }*/

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Column(name = "degree_low")
    private int degreeLow;

    @Column(name = "degree_high")
    private int degreeHigh;

    @Column(name = "points")
    private double points;
}
