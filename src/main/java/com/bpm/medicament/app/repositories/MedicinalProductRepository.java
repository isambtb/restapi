package com.bpm.medicament.app.repositories;

import com.bpm.medicament.app.domain.MedicinalProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MedicinalProductRepository extends JpaRepository<MedicinalProduct, Long> {

    final String getAllPostsByRank= "from MedicinalProduct";

    @Query(getAllPostsByRank)
    List<MedicinalProduct> getAll(Pageable pageable);
}