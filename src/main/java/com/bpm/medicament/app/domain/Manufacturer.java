package com.bpm.medicament.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manufacturer")
@EntityListeners(AuditingEntityListener.class)
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturerCodeSystem;

    private String manufacturerExtention;

    private String manufacturerName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturerCodeSystem() {
        return manufacturerCodeSystem;
    }

    public void setManufacturerCodeSystem(String manufacturerCodeSystem) {
        this.manufacturerCodeSystem = manufacturerCodeSystem;
    }

    public String getManufacturerExtention() {
        return manufacturerExtention;
    }

    public void setManufacturerExtention(String manufacturerExtention) {
        this.manufacturerExtention = manufacturerExtention;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(manufacturerCodeSystem, that.manufacturerCodeSystem) &&
                Objects.equals(manufacturerExtention, that.manufacturerExtention) &&
                Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturerCodeSystem, manufacturerExtention, manufacturerName);
    }
}
