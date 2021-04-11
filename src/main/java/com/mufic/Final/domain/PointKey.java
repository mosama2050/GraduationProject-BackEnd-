package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PointKey implements Serializable {

    @Builder
    public PointKey(int gpaLow, int gpaHigh) {
        this.gpaLow=gpaLow;
        this.gpaHigh=gpaHigh;
    }

    private int gpaLow;
    private int gpaHigh;

}
