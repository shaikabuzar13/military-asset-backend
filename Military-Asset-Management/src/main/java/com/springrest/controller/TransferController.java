package com.springrest.controller;

import com.springrest.model.Transfer;
import com.springrest.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public Transfer addTransfer(@RequestBody Transfer transfer) {
        return transferService.save(transfer);
    }

    @GetMapping
    public List<Transfer> getAllTransfers() {
        return transferService.getAll();
    }
}
