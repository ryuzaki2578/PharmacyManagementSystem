package com.MedicineStock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MedicineStock")
public class MedicineStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String chemicalComposition;
    @Column
    private String targetAilment;
    @Column
    private Date dateOfExpiry;
    @Column
    private long numberOfTabletsInStocks;
}
