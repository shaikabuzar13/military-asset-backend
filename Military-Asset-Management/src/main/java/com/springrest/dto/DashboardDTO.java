package com.springrest.dto;

public class DashboardDTO {
    private String equipmentName;
    private String type;
    private int openingBalance;
    private int purchases;
    private int transfersIn;
    private int transfersOut;
    private int assigned;
    private int expended;

    // Getters and Setters
    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getOpeningBalance() { return openingBalance; }
    public void setOpeningBalance(int openingBalance) { this.openingBalance = openingBalance; }

    public int getPurchases() { return purchases; }
    public void setPurchases(int purchases) { this.purchases = purchases; }

    public int getTransfersIn() { return transfersIn; }
    public void setTransfersIn(int transfersIn) { this.transfersIn = transfersIn; }

    public int getTransfersOut() { return transfersOut; }
    public void setTransfersOut(int transfersOut) { this.transfersOut = transfersOut; }

    public int getAssigned() { return assigned; }
    public void setAssigned(int assigned) { this.assigned = assigned; }

    public int getExpended() { return expended; }
    public void setExpended(int expended) { this.expended = expended; }
}
