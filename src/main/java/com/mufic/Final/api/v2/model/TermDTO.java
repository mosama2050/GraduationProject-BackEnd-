package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TermDTO{

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private String termType;

    private Date start;

    private Date end;

    private Date startRegistration;

    private Date endRegistration;

    private Date startUpdating;

    private Date endUpdating;

    private Date startWithdrawn;

    private Date endWithdrawn;

    private Date createTime;

    private Date updateTime;

    List<Long> courseInTermList;

    @JsonProperty("term_url")
    private String termUrl;

}
