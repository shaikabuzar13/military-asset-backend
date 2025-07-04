package com.springrest.service;

import com.springrest.model.Base;
import com.springrest.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    private final BaseRepository baseRepository;

    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<Base> getAllBases() {
        return baseRepository.findAll();
    }

    // ✅ Add this to support POST
    public Base saveBase(Base base) {
        return baseRepository.save(base);
    }
}
