package com.bpm.medicament.app.domain;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "marketing_act")
@EntityListeners(AuditingEntityListener.class)
public class MarketingAct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String statusCode;

    private String effectiveTimeLow;

    private String effectiveTimeLHeigh;


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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getEffectiveTimeLow() {
        return effectiveTimeLow;
    }

    public void setEffectiveTimeLow(String effectiveTimeLow) {
        this.effectiveTimeLow = effectiveTimeLow;
    }

    public String getEffectiveTimeLHeigh() {
        return effectiveTimeLHeigh;
    }

    public void setEffectiveTimeLHeigh(String effectiveTimeLHeigh) {
        this.effectiveTimeLHeigh = effectiveTimeLHeigh;
    }
}
