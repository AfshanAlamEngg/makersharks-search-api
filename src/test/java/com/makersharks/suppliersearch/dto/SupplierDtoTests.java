package com.makersharks.suppliersearch.dto;

import org.junit.jupiter.api.Test;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

class SupplierDtoTests {

    @Test
    void supplierQueryDtoShouldSetAndGetValues() {
        SupplierQueryDto queryDto = new SupplierQueryDto();
        queryDto.setLocation("New York");
        queryDto.setNatureOfBusiness("small_scale");
        queryDto.setManufacturingProcess("moulding");

        assertThat(queryDto.getLocation()).isEqualTo("New York");
        assertThat(queryDto.getNatureOfBusiness()).isEqualTo("small_scale");
        assertThat(queryDto.getManufacturingProcess()).isEqualTo("moulding");
    }

    @Test
    void supplierResponseDtoShouldSetAndGetValues() {
        SupplierResponseDto responseDto = new SupplierResponseDto();
        responseDto.setSupplierId(UUID.randomUUID());
        responseDto.setCompanyName("ABC Manufacturing");
        responseDto.setWebsite("http://abc.com");
        responseDto.setLocation("New York");
        responseDto.setNatureOfBusiness("small_scale");
        responseDto.setManufacturingProcesses("moulding");

        assertThat(responseDto.getSupplierId()).isNotNull();
        assertThat(responseDto.getCompanyName()).isEqualTo("ABC Manufacturing");
        assertThat(responseDto.getWebsite()).isEqualTo("http://abc.com");
        assertThat(responseDto.getLocation()).isEqualTo("New York");
        assertThat(responseDto.getNatureOfBusiness()).isEqualTo("small_scale");
        assertThat(responseDto.getManufacturingProcesses()).isEqualTo("moulding");
    }
}
