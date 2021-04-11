package com.mufic.Final.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
@Table(name = "countries")
public class Country /*extends BaseEntity */{

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso3")
    private String iso3;

    @Column(name = "iso2")
    private String iso2;

    @Column(name = "phonecode")
    private String phoneCode;

    @Column(name = "capital")
    private String capital;

    @Column(name = "currency")
    private String currency;

    @Column(name = "native")
    private String nativ;

    @Column(name = "emoji")
    private String emoji;

    @Column(name = "emojiU")
    private String emojiU;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "wikidataid")
    private String wikiDataId;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "country", fetch = FetchType.LAZY)
    private List<State> states=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities=new ArrayList<>();

    @Builder
    public Country(Long id, String name, String iso3, String iso2, String phoneCode, String capital, String currency, String nativ, String emoji, String emojiU, Date createdAt, Date updatedAt, boolean flag, String wikiDataId, List<State> states, List<City> cities) {
        this.id=id;
        this.name = name;
        this.iso3 = iso3;
        this.iso2 = iso2;
        this.phoneCode = phoneCode;
        this.capital = capital;
        this.currency = currency;
        this.nativ = nativ;
        this.emoji = emoji;
        this.emojiU = emojiU;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.flag = flag;
        this.wikiDataId = wikiDataId;
        this.states = states;
        this.cities = cities;
    }

    public Country() {
    }
}
