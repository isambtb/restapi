package com.bpm.medicament.app.domain;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "substance")
@EntityListeners(AuditingEntityListener.class)
public class Substance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String  codeSystem;

    private String name;

    private String descr;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "subsance_equivalents", joinColumns = @JoinColumn(name = "substance_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Equivalent> equivalents= new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "subsance_translations", joinColumns = @JoinColumn(name = "substance_id"))
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Set<Equivalent> getEquivalents() {
        return equivalents;
    }

    public void setEquivalents(Set<Equivalent> equivalents) {
        this.equivalents = equivalents;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }
}
