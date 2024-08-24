package com.makersharks.suppliersearch;

import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    private Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new Supplier();
        supplier.setCompanyName("ABC Manufacturing");
        supplier.setWebsite("http://abc.com");
        supplier.setLocation("New York");
        supplier.setNatureOfBusiness("small_scale");
        supplier.setManufacturingProcesses("moulding");
    }

    @Test
    void shouldSaveSupplierSuccessfully() {
        Supplier savedSupplier = supplierRepository.save(supplier);

        assertThat(savedSupplier)
            .as("Check that the supplier was saved successfully")
            .isNotNull();
        assertThat(savedSupplier.getSupplierId())
            .as("Check that the supplier ID is generated")
            .isNotNull();
    }

    // @Test
    // void shouldFindSupplierById() {
    //     Supplier savedSupplier = supplierRepository.save(supplier);
    //     UUID savedSupplierId = savedSupplier.getSupplierId();

    //     Optional<Supplier> foundSupplierOpt = supplierRepository.findById(savedSupplierId);
    //     foundSupplierOpt.ifPresentOrElse(
    //         foundSupplier -> {
    //             assertThat(foundSupplier.getCompanyName())
    //                 .as("Check that the company name matches")
    //                 .isEqualTo("ABC Manufacturing");
    //         },
    //         () -> {
    //             throw new AssertionError("Supplier was not found by ID: " + savedSupplierId);
    //         }
    //     );
    // }
}
