package com.Backend.Entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subPatrolling_id")
    private SubPatrolling subPatrolling;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sector> sectors;

    public SubPatrolling getSubPatrolling() {
        return subPatrolling;
    }

    public void setSubPatrolling(SubPatrolling subPatrolling) {
        this.subPatrolling = subPatrolling;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    

}
