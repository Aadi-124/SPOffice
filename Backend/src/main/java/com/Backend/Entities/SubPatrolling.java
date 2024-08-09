
package com.Backend.Entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subPatrollings")
@Getter
@Setter
public class SubPatrolling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Police head;

    private Police cohead;

    private String description;

    private List<String> instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patrolling_id")
    private Patrolling patrolling;

    @OneToMany(mappedBy = "subPatrolling", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Area> areas;

}
