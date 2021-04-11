package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@Entity
@Table(name = "states")
public class State /*extends BaseEntity*/{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @Column(name = "country_code")
    String countryCode;

    @Column(name = "fips_code")
    String fipsCode;

    @Column(name = "iso2")
    String iso2;

    @CreationTimestamp
    @Column(name = "created_at")
    Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    Date updatedAt;

    @Column(name = "flag")
    boolean flag;

    @Column(name = "wikidataid")
    String wikiDataId;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "country")
    List<City> cities;

    @Builder
    public State(Long id, String name, Country country, String countryCode, String fipsCode, String iso2, Date createdAt, Date updatedAt, boolean flag, String wikiDataId, List<City> cities) {
        this.id=id;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.fipsCode = fipsCode;
        this.iso2 = iso2;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.flag = flag;
        this.wikiDataId = wikiDataId;
        this.cities = cities;
    }

    public State() {
    }
}
