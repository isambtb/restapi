package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Boolean_characteristic")
@EntityListeners(AuditingEntityListener.class)
public class BooleanCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private boolean extMedMgt ;
    private boolean isPerfusion;
    private boolean isMultidose;
    private boolean isWaterScale;
    private boolean isSoluble;
    private boolean isPartionable;
    private boolean isFormulary;
    private boolean inUse;
    private boolean isSpeciality;
    private boolean prescriptionRequired;
    private boolean isNarotic;
    private boolean isForfait;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isExtMedMgt() {
        return extMedMgt;
    }

    public void setExtMedMgt(boolean extMedMgt) {
        this.extMedMgt = extMedMgt;
    }

    public boolean isPerfusion() {
        return isPerfusion;
    }

    public void setPerfusion(boolean perfusion) {
        isPerfusion = perfusion;
    }

    public boolean isMultidose() {
        return isMultidose;
    }

    public void setMultidose(boolean multidose) {
        isMultidose = multidose;
    }

    public boolean isWaterScale() {
        return isWaterScale;
    }

    public void setWaterScale(boolean waterScale) {
        isWaterScale = waterScale;
    }

    public boolean isSoluble() {
        return isSoluble;
    }

    public void setSoluble(boolean soluble) {
        isSoluble = soluble;
    }

    public boolean isPartionable() {
        return isPartionable;
    }

    public void setPartionable(boolean partionable) {
        isPartionable = partionable;
    }

    public boolean isFormulary() {
        return isFormulary;
    }

    public void setFormulary(boolean formulary) {
        isFormulary = formulary;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean isSpeciality() {
        return isSpeciality;
    }

    public void setSpeciality(boolean speciality) {
        isSpeciality = speciality;
    }

    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public boolean isNarotic() {
        return isNarotic;
    }

    public void setNarotic(boolean narotic) {
        isNarotic = narotic;
    }

    public boolean isForfait() {
        return isForfait;
    }

    public void setForfait(boolean forfait) {
        isForfait = forfait;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        BooleanCharacteristic that = (BooleanCharacteristic) o;
        return extMedMgt == that.extMedMgt &&
                isPerfusion == that.isPerfusion &&
                isMultidose == that.isMultidose &&
                isWaterScale == that.isWaterScale &&
                isSoluble == that.isSoluble &&
                isPartionable == that.isPartionable &&
                isFormulary == that.isFormulary &&
                inUse == that.inUse &&
                isSpeciality == that.isSpeciality &&
                prescriptionRequired == that.prescriptionRequired &&
                isNarotic == that.isNarotic &&
                isForfait == that.isForfait;
    }

    @Override
    public int hashCode() {
        return Objects.hash(extMedMgt, isPerfusion, isMultidose, isWaterScale, isSoluble, isPartionable, isFormulary, inUse, isSpeciality, prescriptionRequired, isNarotic, isForfait);
    }
}
