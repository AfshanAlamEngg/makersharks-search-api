package com.makersharks.suppliersearch.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID supplierId;

    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;
}
