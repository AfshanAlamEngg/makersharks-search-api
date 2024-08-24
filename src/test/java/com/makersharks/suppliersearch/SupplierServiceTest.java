package com.makersharks.suppliersearch;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;
import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;
import com.makersharks.suppliersearch.service.SupplierService;
import com.makersharks.suppliersearch.util.ValidationUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SupplierServiceTest {

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ValidationUtil validationUtil;

    public SupplierServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testQuerySuppliers() {
        // Arrange
        SupplierQueryDto queryDto = new SupplierQueryDto();
        Supplier supplier = new Supplier();
        supplier.setCompanyName("Test Supplier");
        SupplierResponseDto responseDto = new SupplierResponseDto();
        responseDto.setCompanyName("Test Supplier");
        Pageable pageable = PageRequest.of(0, 10);
        Page<Supplier> suppliersPage = new PageImpl<>(Collections.singletonList(supplier), pageable, 1);
        when(supplierRepository.findAll(pageable)).thenReturn(suppliersPage);
        when(modelMapper.map(supplier, SupplierResponseDto.class)).thenReturn(responseDto);

        // Act
        Page<SupplierResponseDto> result = supplierService.querySuppliers(queryDto, 0, 10);

        // Assert
        assertEquals(1, result.getContent().size());
        assertEquals("Test Supplier", result.getContent().get(0).getCompanyName());
        verify(validationUtil, times(1)).validateSupplierQuery(queryDto);
    }
}
