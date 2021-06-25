package com.MedicineStock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MedicineStock")
public class MedicineStock {
    @Id
    String name;
    @Column
    String chemicalComposition;
    @Column
    String targetAilment;
    @Column
    Date dateOfExpiry;
    @Column
    long numberOfTabletsInStocks;
}
