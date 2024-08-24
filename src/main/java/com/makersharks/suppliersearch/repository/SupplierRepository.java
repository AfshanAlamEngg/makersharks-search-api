package com.makersharks.suppliersearch.repository;

import com.makersharks.suppliersearch.model.Supplier;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Object findAllById(UUID supplierId);
}
