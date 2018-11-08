package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document")
@EntityListeners(AuditingEntityListener.class)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String codeSystem;
    @Column(length = 1000)
    private String title;
    private String effectiveTimeLow;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "document_characteristics", joinColumns = @JoinColumn(name = "document_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<DocumentCharacteristic> characteristics =new HashSet<>();


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEffectiveTimeLow() {
        return effectiveTimeLow;
    }

    public void setEffectiveTimeLow(String effectiveTimeLow) {
        this.effectiveTimeLow = effectiveTimeLow;
    }

    public Set<DocumentCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<DocumentCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
