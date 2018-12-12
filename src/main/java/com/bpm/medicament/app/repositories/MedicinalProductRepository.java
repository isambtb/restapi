package com.bpm.medicament.app.repositories;

import com.bpm.medicament.app.domain.MedicinalProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query("select m from MedicinalProduct m  where m.code = :code and m.versionNumber=:versionNumber")
    List<MedicinalProduct> getByCodeAndVersion(@Param("code") String code, @Param("versionNumber") Long versionNumber);

    @Query("select new MedicinalProduct(m.id, m.code, m.codeSystem, " +
            "m.medicinalProductName, m.isValidated, m.versionNumber, m.createdOn) from MedicinalProduct m where m.isLastVersion = true")
    List getMedicinalProducts();

    @Query("select m from MedicinalProduct m where m.isLastVersion = true and m.code =:code")
    MedicinalProduct getLastVersion(@Param("code") String code);

    @Modifying
    @Query("UPDATE MedicinalProduct m SET m.isLastVersion = false  WHERE m.id =:id")
    void update(@Param("id")Long id);


}