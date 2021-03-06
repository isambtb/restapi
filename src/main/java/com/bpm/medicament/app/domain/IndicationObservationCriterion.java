package com.bpm.medicament.app.domain;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="indication_observation_criterion")
@EntityListeners(AuditingEntityListener.class)
public class IndicationObservationCriterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String displayName;

    private String valueCode;

    private String valueCodeSystem;

    private String valueDisplayName;


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

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public String getValueCodeSystem() {
        return valueCodeSystem;
    }

    public void setValueCodeSystem(String valueCodeSystem) {
        this.valueCodeSystem = valueCodeSystem;
    }

    public String getValueDisplayName() {
        return valueDisplayName;
    }

    public void setValueDisplayName(String valueDisplayName) {
        this.valueDisplayName = valueDisplayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        IndicationObservationCriterion that = (IndicationObservationCriterion) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(valueCode, that.valueCode) &&
                Objects.equals(valueCodeSystem, that.valueCodeSystem) &&
                Objects.equals(valueDisplayName, that.valueDisplayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, displayName, valueCode, valueCodeSystem, valueDisplayName);
    }
}
