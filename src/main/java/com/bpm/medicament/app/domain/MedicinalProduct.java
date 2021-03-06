package com.bpm.medicament.app.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medicinal_products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MedicinalProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long versionNumber;

    private String createdOn;

    private String updatedOn;

    private String updatedBy;

    @ColumnDefault("false")
    private boolean isValidated;

    private String isValidatedBy;

    @ColumnDefault("true")
    private boolean isLastVersion;


    @NotBlank
    private String code;

    @NotBlank
    private String codeSystem;

    @NotBlank
    private String medicinalProductName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Manufacturer manufacturer;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "medicament_ingredients", joinColumns = @JoinColumn(name = "medicament_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients= new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private AsContent asContent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MarketingAct marketingAct;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ConsumedIn consumedIn;

    public  MedicinalProduct(){

    }


    public MedicinalProduct (Long id, String code, String codeSystem, String medicinalProductName, boolean isValidated,
                             long versionNumber, String createdOn){
        this.id = id;
        this.code =  code;
        this.codeSystem = codeSystem;
        this.medicinalProductName = medicinalProductName;
        this.isValidated = isValidated;
        this.versionNumber = versionNumber;
        this.createdOn = createdOn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public String getIsValidatedBy() {
        return isValidatedBy;
    }

    public void setIsValidatedBy(String isValidatedBy) {
        this.isValidatedBy = isValidatedBy;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public AsContent getAsContent() {
        return asContent;
    }

    public void setAsContent(AsContent asContent) {
        this.asContent = asContent;
    }

    public MarketingAct getMarketingAct() {
        return marketingAct;
    }

    public void setMarketingAct(MarketingAct marketingAct) {
        this.marketingAct = marketingAct;
    }

    public ConsumedIn getConsumedIn() {
        return consumedIn;
    }

    public void setConsumedIn(ConsumedIn consumedIn) {
        this.consumedIn = consumedIn;
    }

    public boolean isLastVersion() {
        return isLastVersion;
    }

    public void setIsLastVersion(boolean lastVersion) {
        isLastVersion = lastVersion;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        final MedicinalProduct other = (MedicinalProduct) obj;
        if (
                medicinalProductName.equals(other.getMedicinalProductName())
                && code.equals(other.getCode())
                && codeSystem.equals(other.getCodeSystem())
        ){
            return  true;
        }

        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        MedicinalProduct that = (MedicinalProduct) o;
        return
                Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(medicinalProductName, that.medicinalProductName) &&
                Objects.equals(manufacturer,  that.manufacturer) &&
                Objects.equals(asContent,  that.asContent) &&
                Objects.equals(marketingAct,  that.marketingAct) &&
                Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, versionNumber, createdOn, updatedOn, updatedBy, isValidated, isValidatedBy, isLastVersion, code, codeSystem, medicinalProductName, manufacturer, ingredients, asContent, marketingAct, consumedIn);
    }
}