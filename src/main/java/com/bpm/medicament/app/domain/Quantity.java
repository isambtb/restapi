package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "quantity")
@EntityListeners(AuditingEntityListener.class)
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nValue;


    private String nUnit;


    private String nDisplayName;


    private String dValue;


    private String dUnit;


    private String dDisplayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnValue() {
        return nValue;
    }

    public void setnValue(String nValue) {
        this.nValue = nValue;
    }

    public String getnUnit() {
        return nUnit;
    }

    public void setnUnit(String nUnit) {
        this.nUnit = nUnit;
    }

    public String getnDisplayName() {
        return nDisplayName;
    }

    public void setnDisplayName(String nDisplayName) {
        this.nDisplayName = nDisplayName;
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }

    public String getdUnit() {
        return dUnit;
    }

    public void setdUnit(String dUnit) {
        this.dUnit = dUnit;
    }

    public String getdDisplayName() {
        return dDisplayName;
    }

    public void setdDisplayName(String dDisplayName) {
        this.dDisplayName = dDisplayName;
    }
}
