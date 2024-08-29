package com.makersharks.suppliersearch.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import lombok.Data;

@Entity
@Table(name = "suppliers")
@Data
public class Supplier {

    @Id
    @GeneratedValue
    private UUID supplierId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String website;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NatureOfBusiness natureOfBusiness;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ManufacturingProcess manufacturingProcesses;

    public enum NatureOfBusiness {
        SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
    }

    public enum ManufacturingProcess {
        MOULDING, PRINTING_3D, CASTING, COATING
    }
}
