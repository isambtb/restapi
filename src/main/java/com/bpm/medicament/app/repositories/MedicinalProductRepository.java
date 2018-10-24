package com.bpm.medicament.app.repositories;

import com.bpm.medicament.app.domain.MedicinalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinalProductRepository extends JpaRepository<MedicinalProduct, Long> {

}