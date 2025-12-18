package com.easybytes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "notice_details")
@Getter
@Setter
public class Notice {

    @Id
    private int noticeId;

    private String noticeSummary;

    private String noticeDetails;

    private Date noticBegDt;

    private Date noticEndDt;

    @JsonIgnore
    private Date createDt;

    @JsonIgnore
    private Date updateDt;

}
