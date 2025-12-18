package com.easybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Cards {

    @Id
    private int cardId;

    private String cardNumber;

    private int customerId;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private Date createDt;

}
