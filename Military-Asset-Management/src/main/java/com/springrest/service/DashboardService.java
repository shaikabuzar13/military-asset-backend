package com.springrest.service;

import com.springrest.dto.DashboardDTO;
import com.springrest.model.Equipment;
import com.springrest.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final EquipmentRepository equipmentRepository;

    public DashboardService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<DashboardDTO> getDashboardData() {
        return equipmentRepository.findAll().stream().map(equipment -> {
            DashboardDTO dto = new DashboardDTO();
            dto.setEquipmentName(equipment.getName());
            dto.setType(equipment.getType());
            dto.setOpeningBalance(equipment.getOpeningBalance());
            dto.setPurchases(equipment.getPurchases());
            dto.setTransfersIn(equipment.getTransfersIn());
            dto.setTransfersOut(equipment.getTransfersOut());
            dto.setAssigned(equipment.getAssigned());
            dto.setExpended(equipment.getExpended());
            return dto;
        }).collect(Collectors.toList());
    }
}
