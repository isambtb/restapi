package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "as_specialized_kind")
@EntityListeners(AuditingEntityListener.class)
public class AsSpecializedKind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String displayName;

    @ManyToOne(cascade = CascadeType.ALL)
    private  GeneralizedMaterialKind generalizedMaterialKind;

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

    public GeneralizedMaterialKind getGeneralizedMaterialKind() {
        return generalizedMaterialKind;
    }

    public void setGeneralizedMaterialKind(GeneralizedMaterialKind generalizedMaterialKind) {
        this.generalizedMaterialKind = generalizedMaterialKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        AsSpecializedKind that = (AsSpecializedKind) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(generalizedMaterialKind, that.generalizedMaterialKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, displayName, generalizedMaterialKind);
    }
}
