package com.springrest.service;

import com.springrest.model.Purchase;
import com.springrest.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> getFilteredPurchases(Long equipmentId, Long baseId, LocalDate startDate, LocalDate endDate) {
        return purchaseRepository.findAll().stream().filter(purchase -> {
            boolean matches = true;
            if (equipmentId != null) matches &= purchase.getEquipmentId().equals(equipmentId);
            if (baseId != null) matches &= purchase.getBaseId().equals(baseId);
            if (startDate != null) matches &= !purchase.getPurchaseDate().isBefore(startDate);
            if (endDate != null) matches &= !purchase.getPurchaseDate().isAfter(endDate);
            return matches;
        }).collect(Collectors.toList());
    }
}
