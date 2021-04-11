package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO{

    private Long id;

    private int student;

    private int term;

    private int courseCnt;

    private double total;

    private int billNo;

    private Date createTime;

    @JsonProperty("Transaction_url")
    private String transactionUrl;

}
