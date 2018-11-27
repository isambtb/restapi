package com.bpm.medicament.app.controllers;

public class MedicinalProductdto {

    private Long _id;
    private String code;
    private String codeSystem;
    private String medicinalProductName;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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
}
