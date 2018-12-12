package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "as_content_sub")
@EntityListeners(AuditingEntityListener.class)
public class AsContentSub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Quantity quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private ContainerPackageProductSub containerPackagedProduct;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "as_content_sub_characteristics", joinColumns = @JoinColumn(name = "as_content_sub_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Characteristic> characteristics = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "as_content_sub_policies", joinColumns = @JoinColumn(name = "as_content_sub_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Policy> policies  = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private MarketingAct marketingAct;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public ContainerPackageProductSub getContainerPackagedProduct() {
        return containerPackagedProduct;
    }

    public void setContainerPackagedProduct(ContainerPackageProductSub containerPackagedProduct) {
        this.containerPackagedProduct = containerPackagedProduct;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Set<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(Set<Policy> policies) {
        this.policies = policies;
    }

    public MarketingAct getMarketingAct() {
        return marketingAct;
    }

    public void setMarketingAct(MarketingAct marketingAct) {
        this.marketingAct = marketingAct;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        AsContentSub that = (AsContentSub) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(containerPackagedProduct, that.containerPackagedProduct) &&
                Objects.equals(characteristics, that.characteristics) &&
                Objects.equals(policies, that.policies) &&
                Objects.equals(marketingAct, that.marketingAct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, containerPackagedProduct, characteristics, policies, marketingAct);
    }
}
