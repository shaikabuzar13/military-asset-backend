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
}
