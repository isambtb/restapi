package com.bpm.medicament.app.domain;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
@EntityListeners(AuditingEntityListener.class)
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classCode;

    @ManyToOne(cascade = CascadeType.ALL)
    private Quantity quantity;


    @ManyToOne(cascade = CascadeType.ALL)
    private Substance ingredientSubstance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Substance getIngredientSubstance() {
        return ingredientSubstance;
    }

    public void setIngredientSubstance(Substance ingredientSubstance) {
        this.ingredientSubstance = ingredientSubstance;
    }
}
