package com.springrest.controller;

import com.springrest.model.Purchase;
import com.springrest.service.PurchaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases(
            @RequestParam(required = false) Long equipmentId,
            @RequestParam(required = false) Long baseId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        if (equipmentId == null && baseId == null && startDate == null && endDate == null) {
            return purchaseService.getAll();
        }
        return purchaseService.getFilteredPurchases(equipmentId, baseId, startDate, endDate);
    }
}
