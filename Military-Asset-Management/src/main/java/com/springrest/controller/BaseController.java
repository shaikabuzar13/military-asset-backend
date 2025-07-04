package com.springrest.controller;

import com.springrest.model.Base;
import com.springrest.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bases")
public class BaseController {

    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<Base> getAll() {
        return baseService.getAllBases();
    }

    @PostMapping("/add") // This is what your URL must match
    public Base createBase(@RequestBody Base base) {
        System.out.println("✅ POST /api/bases/add called");
        return baseService.saveBase(base);
    }
}

