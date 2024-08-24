package com.makersharks.suppliersearch.util;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.exception.ResourceNotFoundException;

public class ValidationUtil {

    public static void validateSupplierQuery(SupplierQueryDto queryDto) {
        if (queryDto.getLocation() == null || queryDto.getLocation().isEmpty()) {
            throw new ResourceNotFoundException("Location cannot be null or empty");
        }

        if (queryDto.getNatureOfBusiness() == null || queryDto.getNatureOfBusiness().isEmpty()) {
            throw new ResourceNotFoundException("Nature of business cannot be null or empty");
        }

        if (queryDto.getManufacturingProcess() == null || queryDto.getManufacturingProcess().isEmpty()) {
            throw new ResourceNotFoundException("Manufacturing process cannot be null or empty");
        }
    }
}
