package com.springrest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long equipmentId;
    private Long baseId;

    private String personnelName;
    private int quantityAssigned;
    private int quantityExpended;

    private LocalDate assignmentDate;

    public Assignment() {
        this.assignmentDate = LocalDate.now(); // default to today
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public Long getBaseId() { return baseId; }
    public void setBaseId(Long baseId) { this.baseId = baseId; }

    public String getPersonnelName() { return personnelName; }
    public void setPersonnelName(String personnelName) { this.personnelName = personnelName; }

    public int getQuantityAssigned() { return quantityAssigned; }
    public void setQuantityAssigned(int quantityAssigned) { this.quantityAssigned = quantityAssigned; }

    public int getQuantityExpended() { return quantityExpended; }
    public void setQuantityExpended(int quantityExpended) { this.quantityExpended = quantityExpended; }

    public LocalDate getAssignmentDate() { return assignmentDate; }
    public void setAssignmentDate(LocalDate assignmentDate) { this.assignmentDate = assignmentDate; }
}
