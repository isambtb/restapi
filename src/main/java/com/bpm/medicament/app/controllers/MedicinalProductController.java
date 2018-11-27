package com.bpm.medicament.app.controllers;


import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.domain.ResourceNotFoundException;
import com.bpm.medicament.app.repositories.MedicinalProductRepository;
import com.sun.java.swing.plaf.motif.MotifEditorPaneUI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicinalProducts")
public class MedicinalProductController {

    @Autowired
    MedicinalProductRepository medicinalProductRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    @ResponseBody
    public List<MedicinalProductdto> getAllNotes()

    {
        List<MedicinalProduct> medicinalProducts= medicinalProductRepository.getMedicinalProducts();
        return medicinalProducts.stream().map(medicinalProduct -> convertToDto(medicinalProduct)).collect(Collectors.toList());
    }

    @RequestMapping("/pages/{pageno}/{psize}")
    @ResponseBody
    public List<MedicinalProduct> getAllPosts(@PathVariable("pageno") int pageno, @PathVariable("psize") int psize, HttpServletRequest req, HttpServletResponse res) throws ServletException {

        return  medicinalProductRepository.getAll(new PageRequest(pageno,psize));
    }

    // Update a Note
    @PostMapping("/update/{id}")
    public MedicinalProduct updateNote(@PathVariable(value = "id") Long medicinalProductId,
                           @Valid @RequestBody MedicinalProduct medicinalProduct) {
        medicinalProductRepository.save(medicinalProduct);
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

    @GetMapping("/search/{code}")
    public List<MedicinalProduct> search(@PathVariable(value = "code") String code){
        return medicinalProductRepository.getByCode(code);
    }

    private MedicinalProductdto convertToDto (MedicinalProduct medicinalProduct){
        MedicinalProductdto postDto = modelMapper.map(medicinalProduct, MedicinalProductdto.class);
        return postDto;
    }

}