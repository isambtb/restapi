package com.bpm.medicament.app.controllers;

public class MedicinalProductdto {

    private Long id;
    private String code;
    private String codeSystem;
    private String medicinalProductName;
    private boolean isValidated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String getMedicinalProductName() {
        return medicinalProductName;
    }

    public void setMedicinalProductName(String medicinalProductName) {
        this.medicinalProductName = medicinalProductName;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }
}
