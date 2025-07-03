package com.springrest.service;

import com.springrest.model.Transfer;
import com.springrest.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }
}
