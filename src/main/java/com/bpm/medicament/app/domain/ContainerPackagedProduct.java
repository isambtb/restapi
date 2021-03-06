package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "as_content_documents", joinColumns = @JoinColumn(name = "as_content_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Document> documents= new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "as_content_valued_Items", joinColumns = @JoinColumn(name = "as_content_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ValuedIem>  valuedItems = new HashSet<>();


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

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<ValuedIem> getValuedItems() {
        return valuedItems;
    }

    public void setValuedItems(Set<ValuedIem> valuedItems) {
        this.valuedItems = valuedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        ContainerPackagedProduct that = (ContainerPackagedProduct) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(codeSystem, that.codeSystem) &&
                Objects.equals(name, that.name) &&
                Objects.equals(formCode, that.formCode) &&
                Objects.equals(asSpecializedKinds, that.asSpecializedKinds) &&
                Objects.equals(asContentSub, that.asContentSub) &&
                Objects.equals(documents, that.documents) &&
                Objects.equals(valuedItems, that.valuedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codeSystem, name, formCode, asSpecializedKinds, asContentSub, documents, valuedItems);
    }
}
