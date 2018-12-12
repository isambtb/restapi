package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "code")
@EntityListeners(AuditingEntityListener.class)
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code) &&
                Objects.equals(codeSystem, code1.codeSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem);
    }
}
