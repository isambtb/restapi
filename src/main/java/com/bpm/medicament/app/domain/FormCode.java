package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "form_code")
@EntityListeners(AuditingEntityListener.class)
public class FormCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String desplayName;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "form_translations", joinColumns = @JoinColumn(name = "forme_code_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Translation> translations= new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        FormCode formCode = (FormCode) o;
        return Objects.equals(code, formCode.code) &&
                Objects.equals(codeSystem, formCode.codeSystem) &&
                Objects.equals(desplayName, formCode.desplayName) &&
                Objects.equals(translations, formCode.translations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, desplayName, translations);
    }
}
