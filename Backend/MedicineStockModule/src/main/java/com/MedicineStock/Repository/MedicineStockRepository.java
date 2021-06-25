package com.MedicineStock.Repository;

import com.MedicineStock.Model.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock,String> {
}
