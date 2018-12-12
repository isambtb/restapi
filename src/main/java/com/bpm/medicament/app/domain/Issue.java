package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="issue")
@EntityListeners(AuditingEntityListener.class)
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "clinical_situation_criterions", joinColumns = @JoinColumn(name = "issue_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ClinicalSituationCriterion> clinicalSituationCriterions = new HashSet<>();

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


    public Set<ClinicalSituationCriterion> getClinicalSituationCriterions() {
        return clinicalSituationCriterions;
    }

    public void setClinicalSituationCriterions(Set<ClinicalSituationCriterion> clinicalSituationCriterions) {
        this.clinicalSituationCriterions = clinicalSituationCriterions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Issue issue = (Issue) o;
        return Objects.equals(code, issue.code) &&
                Objects.equals(codeSystem, issue.codeSystem) &&
                Objects.equals(clinicalSituationCriterions, issue.clinicalSituationCriterions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, clinicalSituationCriterions);
    }
}
