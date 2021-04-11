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
@Table(name = "Program_Levels")
public class ProgramLevel extends BaseEntity{

//    @Builder
/*    public ProgramLevel(Long id, String nameEnglish, String nameArabic, int minHours) {
        super(id);
        this.nameEnglish=nameEnglish;
        this.nameArabic=nameArabic;
        this.minHours=minHours;
    }*/

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Column(name = "min_hours")
    private int minHours;

}
