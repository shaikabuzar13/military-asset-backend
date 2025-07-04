package com.springrest.controller;

import com.springrest.dto.DashboardDTO;
import com.springrest.dto.DashboardResponse;
import com.springrest.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping
    public DashboardResponse getDashboardData() {
        DashboardResponse dto = new DashboardResponse();
        dto.setOpeningBalance(100);
        dto.setPurchases(40);
        dto.setTransferIn(30);
        dto.setTransferOut(10);
        dto.setNetMovement(60); // purchases + in - out
        dto.setClosingBalance(160); // opening + net movement
        dto.setAssigned(20);
        dto.setExpended(5);
        return dto;
    }
}
