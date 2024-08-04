package com.Backend.Entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String district;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subadmin> subadmins;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Patrolling> patrollings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Set<Subadmin> getSubadmins() {
        return subadmins;
    }

    public void setSubadmins(Set<Subadmin> subadmins) {
        this.subadmins = subadmins;
    }

    public Set<Patrolling> getPatrollings() {
        return patrollings;
    }

    public void setPatrollings(Set<Patrolling> patrollings) {
        this.patrollings = patrollings;
    }


}
