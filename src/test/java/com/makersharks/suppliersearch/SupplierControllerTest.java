package com.makersharks.suppliersearch;

import com.makersharks.suppliersearch.controller.SupplierController;
import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;
import com.makersharks.suppliersearch.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SupplierControllerTest {

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    public SupplierControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testQuerySuppliers() {
        // Arrange
        SupplierQueryDto queryDto = new SupplierQueryDto();
        SupplierResponseDto responseDto = new SupplierResponseDto();
        responseDto.setCompanyName("Test Supplier");
        Page<SupplierResponseDto> page = new PageImpl<>(Collections.singletonList(responseDto));
        when(supplierService.querySuppliers(any(SupplierQueryDto.class), anyInt(), anyInt())).thenReturn(page);

        // Act
        ResponseEntity<Page<SupplierResponseDto>> response = supplierController.querySuppliers(queryDto, 0, 10);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().getContent().size());
        assertEquals("Test Supplier", response.getBody().getContent().get(0).getCompanyName());
    }
}
