package com.bpm.medicament.app.repositories;

import com.bpm.medicament.app.domain.MedicinalProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinalProductPaginableRepository  extends PagingAndSortingRepository<MedicinalProduct, Long> {

}
