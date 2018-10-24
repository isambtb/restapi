package com.bpm.medicament.app.controllers;


import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.domain.ResourceNotFoundException;
import com.bpm.medicament.app.repositories.MedicinalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/medicinalProducts")
public class MedicinalProductController {

    @Autowired
    MedicinalProductRepository medicinalProductRepository;

    // Create a new Note
    @PostMapping("/")
    public MedicinalProduct createMedicinalProduct(@Valid @RequestBody MedicinalProduct medicinalProduct) {
        return medicinalProductRepository.save(medicinalProduct);
    }

    // Get a Single Note
    @GetMapping("/{id}")
    public MedicinalProduct getNoteById(@PathVariable(value = "id") Long medicinalProductId) {
        return medicinalProductRepository.findById(medicinalProductId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicinalProduct", "id", medicinalProductId));
    }

    // Get All Notes
    @GetMapping("/")
    public List<MedicinalProduct> getAllNotes()
    {
        return  medicinalProductRepository.findAll();
    }



    // Update a Note
    @PutMapping("/{id}")
    public MedicinalProduct updateNote(@PathVariable(value = "id") Long medicinalProductId,
                           @Valid @RequestBody MedicinalProduct medicinalProductDetails) {

        MedicinalProduct medicinalProduct = medicinalProductRepository.findById(medicinalProductId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicinalProduct", "id", medicinalProductId));

        // updates

        medicinalProduct = medicinalProductRepository.save(medicinalProduct);
        return medicinalProduct;
    }

    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long medicinalProductId) {
        MedicinalProduct medicinalProduct = medicinalProductRepository.findById(medicinalProductId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicinalProduct", "id", medicinalProductId));

        medicinalProductRepository.delete(medicinalProduct);

        return ResponseEntity.ok().build();
    }
}