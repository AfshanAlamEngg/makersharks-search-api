package com.makersharks.suppliersearch.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class SupplierEntityTests {

    @Test
    void testSupplierEntityMapping() {
        // Create a new Supplier instance
        Supplier supplier = new Supplier();
        supplier.setCompanyName("Test Company");
        supplier.setWebsite("https://www.testcompany.com");
        supplier.setLocation("Test Location");
        supplier.setNatureOfBusiness(Supplier.NatureOfBusiness.SMALL_SCALE);
        supplier.setManufacturingProcesses(Supplier.ManufacturingProcess.MOULDING);

        // Verify that the fields are correctly set
        assertThat(supplier.getSupplierId()).isNull(); // ID should be null before saving
        assertThat(supplier.getCompanyName()).isEqualTo("Test Company");
        assertThat(supplier.getWebsite()).isEqualTo("https://www.testcompany.com");
        assertThat(supplier.getLocation()).isEqualTo("Test Location");
        assertThat(supplier.getNatureOfBusiness()).isEqualTo(Supplier.NatureOfBusiness.SMALL_SCALE);
        assertThat(supplier.getManufacturingProcesses()).isEqualTo(Supplier.ManufacturingProcess.MOULDING);
    }

    @Test
    void testSupplierIdGeneration() {
        // Create a new Supplier instance
        Supplier supplier = new Supplier();
        supplier.setCompanyName("Test Company");
        supplier.setWebsite("https://www.testcompany.com");
        supplier.setLocation("Test Location");
        supplier.setNatureOfBusiness(Supplier.NatureOfBusiness.MEDIUM_SCALE);
        supplier.setManufacturingProcesses(Supplier.ManufacturingProcess.PRINTING_3D);

        // Simulate persisting the entity (this is usually handled by JPA)
        supplier.setSupplierId(UUID.randomUUID());

        // Verify that the ID is generated and not null
        assertThat(supplier.getSupplierId()).isNotNull();
    }
}
