package com.Backend.Entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "patrollings")
public class Patrolling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "patrolling", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubPatrolling> subPatrollings;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Set<SubPatrolling> getSubPatrollings() {
        return subPatrollings;
    }

    public void setSubPatrollings(Set<SubPatrolling> subPatrollings) {
        this.subPatrollings = subPatrollings;
    }

    

}
