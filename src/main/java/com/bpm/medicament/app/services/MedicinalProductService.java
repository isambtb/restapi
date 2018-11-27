package com.bpm.medicament.app.services;

import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.repositories.MedicinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MedicinalProductService {

    @Autowired
    MedicinalProductRepository medicinalProductRepository;

    public List<MedicinalProduct> getMedicinalProducts(){
        List<MedicinalProduct>  medicinalProducts = medicinalProductRepository.getAllMedicinalProducts();
        return  medicinalProducts.stream().map(
                medicinalProduct -> toMedi(medicinalProduct))
                .collect(Collectors.toList());
    }

    private MedicinalProduct toMedi(Object object){
        return  new MedicinalProduct();
    }
}
