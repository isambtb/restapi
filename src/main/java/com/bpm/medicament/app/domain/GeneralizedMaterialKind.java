package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "generalized_material_kind")
@EntityListeners(AuditingEntityListener.class)
public class GeneralizedMaterialKind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String displayName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "generalizedMaterialKind_translations", joinColumns = @JoinColumn(name = "generalizedMaterialKind_code_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Translation> translations= new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        GeneralizedMaterialKind that = (GeneralizedMaterialKind) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(translations, that.translations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, displayName, translations);
    }
}

