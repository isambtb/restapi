package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "equivalent")
@EntityListeners(AuditingEntityListener.class)
public class Equivalent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String codeSystem;

    private String diaplayName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDiaplayName() {
        return diaplayName;
    }

    public void setDiaplayName(String diaplayName) {
        this.diaplayName = diaplayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Equivalent that = (Equivalent) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(diaplayName, that.diaplayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, diaplayName);
    }
}
