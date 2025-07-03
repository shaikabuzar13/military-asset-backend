package com.springrest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private int openingBalance;
    private int purchases;
    private int transfersIn;
    private int transfersOut;
    private int assigned;
    private int expended;

    public Equipment() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getOpeningBalance() {
        return openingBalance;
    }

    public int getPurchases() {
        return purchases;
    }

    public int getTransfersIn() {
        return transfersIn;
    }

    public int getTransfersOut() {
        return transfersOut;
    }

    public int getAssigned() {
        return assigned;
    }

    public int getExpended() {
        return expended;
    }

    public int getClosingBalance() {
        return openingBalance + purchases + transfersIn - transfersOut - assigned - expended;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOpeningBalance(int openingBalance) {
        this.openingBalance = openingBalance;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public void setTransfersIn(int transfersIn) {
        this.transfersIn = transfersIn;
    }

    public void setTransfersOut(int transfersOut) {
        this.transfersOut = transfersOut;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public void setExpended(int expended) {
        this.expended = expended;
    }
}
