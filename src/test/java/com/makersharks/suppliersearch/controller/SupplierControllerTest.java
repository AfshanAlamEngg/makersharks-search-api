package com.makersharks.suppliersearch.controller;

import com.makersharks.suppliersearch.dto.SupplierQueryDto;
import com.makersharks.suppliersearch.dto.SupplierResponseDto;
import com.makersharks.suppliersearch.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplierController.class)
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testQuerySuppliers() throws Exception {
        SupplierQueryDto queryDto = new SupplierQueryDto();
        SupplierResponseDto responseDto = new SupplierResponseDto();
        responseDto.setCompanyName("Example Company");

        Page<SupplierResponseDto> mockPage = new PageImpl<>(Collections.singletonList(responseDto));
        when(supplierService.querySuppliers(queryDto, 0, 10)).thenReturn(mockPage);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/supplier/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"someField\": \"someValue\"}") // Adjust this JSON based on your SupplierQueryDto fields
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].companyName").value("Example Company"));
    }
}
