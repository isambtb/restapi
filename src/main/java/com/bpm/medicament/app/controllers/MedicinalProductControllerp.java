package com.bpm.medicament.app.controllers;

import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.repositories.MedicinalProductPaginableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/medicinalProductspage")
public class MedicinalProductControllerp {

    @Autowired
    MedicinalProductPaginableRepository productPaginableRepository;

    // Get All Notes
    @GetMapping("/")
    public Page<MedicinalProduct>  getAll(Pageable pageable)
    {
        System.out.print(pageable.toString());
        return  productPaginableRepository.findAll(pageable);
    }


}
