package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "as_specialized_kind")
@EntityListeners(AuditingEntityListener.class)
public class AsSpecializedKind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String desplayName;

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

    public String getDesplayName() {
        return desplayName;
    }

    public void setDesplayName(String desplayName) {
        this.desplayName = desplayName;
    }

    public GeneralizedMaterialKind getGeneralizedMaterialKind() {
        return generalizedMaterialKind;
    }

    public void setGeneralizedMaterialKind(GeneralizedMaterialKind generalizedMaterialKind) {
        this.generalizedMaterialKind = generalizedMaterialKind;
    }
}
