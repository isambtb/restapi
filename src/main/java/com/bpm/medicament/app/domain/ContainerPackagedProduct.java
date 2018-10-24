package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "container_package_product")
@EntityListeners(AuditingEntityListener.class)
public class ContainerPackagedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String codeSystem;

    private String name;

    // as named entity set

    @ManyToOne(cascade = CascadeType.ALL)
    private FormCode formCode;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_as_specialzed_kind", joinColumns = @JoinColumn(name = "container_package_product_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AsSpecializedKind> asSpecializedKinds= new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_as_content_sub", joinColumns = @JoinColumn(name = "container_package_product_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AsContentSub> asContentSub = new HashSet<>();

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

    public FormCode getFormCode() {
        return formCode;
    }

    public void setFormCode(FormCode formCode) {
        this.formCode = formCode;
    }

    public Set<AsSpecializedKind> getAsSpecializedKinds() {
        return asSpecializedKinds;
    }

    public void setAsSpecializedKinds(Set<AsSpecializedKind> asSpecializedKinds) {
        this.asSpecializedKinds = asSpecializedKinds;
    }

    public Set<AsContentSub> getAsContentSub() {
        return asContentSub;
    }

    public void setAsContentSub(Set<AsContentSub> asContentSub) {
        this.asContentSub = asContentSub;
    }
}
