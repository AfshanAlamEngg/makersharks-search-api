package com.makersharks.suppliersearch.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class SupplierResponseDto {
    private UUID supplierId;
    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;
}
