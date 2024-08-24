package com.makersharks.suppliersearch.service;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;
import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;
import com.makersharks.suppliersearch.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<SupplierResponseDto> querySuppliers(SupplierQueryDto queryDto, int page, int size) {
        ValidationUtil.validateSupplierQuery(queryDto);
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierRepository.findAll(pageable);
        return suppliers.map(supplier -> modelMapper.map(supplier, SupplierResponseDto.class));
    }
}
