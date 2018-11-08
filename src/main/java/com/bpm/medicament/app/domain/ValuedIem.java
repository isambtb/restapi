package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "valued_item")
@EntityListeners(AuditingEntityListener.class)
public class ValuedIem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String diplayName;

    private String effectiveTimeLow;

    private String effectiveTimeHeigh;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "valued_item_unity", joinColumns = @JoinColumn(name = "valued_item_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ValuedUnitItem> valuedUnitItems;


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

    public String getDiplayName() {
        return diplayName;
    }

    public void setDiplayName(String diplayName) {
        this.diplayName = diplayName;
    }

    public String getEffectiveTimeLow() {
        return effectiveTimeLow;
    }

    public void setEffectiveTimeLow(String effectiveTimeLow) {
        this.effectiveTimeLow = effectiveTimeLow;
    }

    public String getEffectiveTimeHeigh() {
        return effectiveTimeHeigh;
    }

    public void setEffectiveTimeHeigh(String effectiveTimeHeigh) {
        this.effectiveTimeHeigh = effectiveTimeHeigh;
    }

    public Set<ValuedUnitItem> getValuedUnitItems() {
        return valuedUnitItems;
    }

    public void setValuedUnitItems(Set<ValuedUnitItem> valuedUnitItems) {
        this.valuedUnitItems = valuedUnitItems;
    }
}
