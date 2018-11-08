package com.bpm.medicament.app.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "as_content ")
@EntityListeners(AuditingEntityListener.class)
public class AsContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    private Quantity quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private ContainerPackagedProduct containerPackagedProduct;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "as_content_characteristics", joinColumns = @JoinColumn(name = "as_content_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Characteristic> characteristics= new HashSet<>();

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

    public ContainerPackagedProduct getContainerPackagedProduct() {
        return containerPackagedProduct;
    }

    public void setContainerPackagedProduct(ContainerPackagedProduct containerPackagedProduct) {
        this.containerPackagedProduct = containerPackagedProduct;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

}
