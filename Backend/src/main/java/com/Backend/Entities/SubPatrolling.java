
package com.Backend.Entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "subPatrollings")
public class SubPatrolling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patrolling_id")
    private Patrolling patrolling;

    @OneToMany(mappedBy = "subPatrolling", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Area> areas;

    public Patrolling getPatrolling() {
        return patrolling;
    }

    public void setPatrolling(Patrolling patrolling) {
        this.patrolling = patrolling;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    

}
