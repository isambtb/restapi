package com.bpm.medicament.app.repositories;

import com.bpm.medicament.app.domain.MedicinalProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MedicinalProductRepository extends JpaRepository<MedicinalProduct, Long> {

    final String getAllPostsByRank= "from MedicinalProduct";

    @Query(getAllPostsByRank)
    List<MedicinalProduct> getAll(Pageable pageable);

    @Query("select m from MedicinalProduct m  where m.code = :code")
    List<MedicinalProduct> getByCode(@Param("code") String code);

    @Query("select new MedicinalProduct(m.id, m.code, m.codeSystem, m.medicinalProductName, m.isValidated) from MedicinalProduct m")
    List getMedicinalProducts();


}