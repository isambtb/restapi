package com.bpm.medicament.app.domain;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="route")
@EntityListeners(AuditingEntityListener.class)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String displayName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "route_translations", joinColumns = @JoinColumn(name = "route_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Translation> translations = new HashSet<>();

    private String doseQuantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private IndicationObservationCriterion indicationObservationCriterion;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

    public String getDoseQuantity() {
        return doseQuantity;
    }

    public void setDoseQuantity(String doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public IndicationObservationCriterion getIndicationObservationCriterion() {
        return indicationObservationCriterion;
    }

    public void setIndicationObservationCriterion(IndicationObservationCriterion indicationObservationCriterion) {
        this.indicationObservationCriterion = indicationObservationCriterion;
    }
}
