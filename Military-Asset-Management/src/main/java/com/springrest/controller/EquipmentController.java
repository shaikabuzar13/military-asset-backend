package com.springrest.controller;


import com.springrest.model.Equipment;
import com.springrest.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @PostMapping
    public Equipment add(@RequestBody Equipment equipment) {
        return equipmentService.saveEquipment(equipment);
    }
}

