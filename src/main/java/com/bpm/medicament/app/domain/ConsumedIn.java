package com.bpm.medicament.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="consumed_in")
@EntityListeners(AuditingEntityListener.class)
public class ConsumedIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "consumedIn_routes", joinColumns = @JoinColumn(name = "consumedIn_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Route> routes = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "consumedIn_issues", joinColumns = @JoinColumn(name = "consumedIn_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Issue> issues = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        ConsumedIn that = (ConsumedIn) o;
        return Objects.equals(routes, that.routes) &&
                Objects.equals(issues, that.issues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routes, issues);
    }
}
