package com.makersharks.suppliersearch.controller;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;
import com.makersharks.suppliersearch.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<SupplierResponseDto>> querySuppliers(@RequestBody SupplierQueryDto queryDto,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        Page<SupplierResponseDto> result = supplierService.querySuppliers(queryDto, page, size);
        return ResponseEntity.ok(result);
    }
}
