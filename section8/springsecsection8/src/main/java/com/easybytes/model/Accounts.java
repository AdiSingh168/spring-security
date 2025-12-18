package com.easybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Accounts {

    @Id
    private int accountNumber;

    private long customerId;

    private String accountType;

    private String branchAddress;

    private Date createDt;

}
