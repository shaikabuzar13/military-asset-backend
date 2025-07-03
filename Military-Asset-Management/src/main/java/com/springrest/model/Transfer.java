package com.springrest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long equipmentId;
    private Long fromBaseId;
    private Long toBaseId;
    private int quantity;

    private LocalDateTime transferDate;

    public Transfer() {
        this.transferDate = LocalDateTime.now(); // Default to current time
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public Long getFromBaseId() { return fromBaseId; }
    public void setFromBaseId(Long fromBaseId) { this.fromBaseId = fromBaseId; }

    public Long getToBaseId() { return toBaseId; }
    public void setToBaseId(Long toBaseId) { this.toBaseId = toBaseId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDateTime getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDateTime transferDate) { this.transferDate = transferDate; }
}
