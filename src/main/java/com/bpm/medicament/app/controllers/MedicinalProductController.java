package com.bpm.medicament.app.controllers;


import com.bpm.medicament.app.domain.MedicinalProduct;
import com.bpm.medicament.app.domain.ResourceNotFoundException;
import com.bpm.medicament.app.repositories.MedicinalProductRepository;
import com.bpm.medicament.app.services.MedicinalProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    MedicinalProductService medicinalProductService;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new Medicinal Product
    @PostMapping("/")
    public MedicinalProduct createMedicinalProduct(@Valid @RequestBody MedicinalProduct medicinalProduct) {
        return medicinalProductRepository.save(medicinalProduct);
    }

    // Create a new Medicinal Product version if there is some changes
    @PostMapping("/flux-BlueWay")
    public MedicinalProduct fluxMedicinalProduct(@Valid @RequestBody MedicinalProduct medicinalProduct) {
        return medicinalProductService.saveMp(medicinalProduct);
    }

    //
    // Create a new Medicinal Product version if there is some changes
    @PostMapping("/update-pharmacist")
    public MedicinalProduct pharmacistMedicinalProduct(@Valid @RequestBody MedicinalProduct medicinalProduct) {
        return medicinalProductService.saveMp(medicinalProduct);
    }


    // Get a Single MedicinalProduct
    @GetMapping("/{id}")
    public MedicinalProduct getMedicinalProductById(@PathVariable(value = "id") Long medicinalProductId) {
        return medicinalProductRepository.findById(medicinalProductId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicinalProduct", "id", medicinalProductId));
    }

    // Get All Medicinal Products
    @GetMapping("/")
    @ResponseBody
    public List<MedicinalProductdto> getAllMedicinalProducts()

    {
        List<MedicinalProduct> medicinalProducts= medicinalProductRepository.getMedicinalProducts();
        return medicinalProducts.stream()
                .map(medicinalProduct -> convertToDto(medicinalProduct))
                .collect(Collectors.toList());
    }

    @RequestMapping("/pages/{pageno}/{psize}")
    @ResponseBody
    public List<MedicinalProduct> getAllMedicinalProducts(@PathVariable("pageno") int pageno, @PathVariable("psize") int psize, HttpServletRequest req, HttpServletResponse res) throws ServletException {

        return  medicinalProductRepository.getAll(new PageRequest(pageno,psize));
    }

    // Update a Medicinal Product
    @PostMapping("/update/{id}")
    public MedicinalProduct updateMedicinalProduct(@PathVariable(value = "id") Long medicinalProductId,
                           @Valid @RequestBody MedicinalProduct medicinalProduct) {
        medicinalProductRepository.save(medicinalProduct);
        return medicinalProduct;
    }

    // Delete a Medicinal Product
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicinalProduct(@PathVariable(value = "id") Long medicinalProductId) {
        MedicinalProduct medicinalProduct = medicinalProductRepository.findById(medicinalProductId)
                .orElseThrow(() -> new ResourceNotFoundException("MedicinalProduct", "id", medicinalProductId));

        medicinalProductRepository.delete(medicinalProduct);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{code}")
    public List<MedicinalProduct> search(@PathVariable(value = "code") String code){
        return medicinalProductRepository.getByCode(code);
    }

    @GetMapping("/search/{code}/{version}")
    public List<MedicinalProduct> search(@PathVariable(value = "code") String code, @PathVariable(value = "version") Long version ){
        return medicinalProductRepository.getByCodeAndVersion(code, version);
    }

    private MedicinalProductdto convertToDto (MedicinalProduct medicinalProduct){
        MedicinalProductdto postDto = modelMapper.map(medicinalProduct, MedicinalProductdto.class);
        return postDto;
    }

}