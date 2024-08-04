package com.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "polices")
public class Police {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String phone;

    private String email;

    @Column(nullable = false)
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subadmin_id")
    @JsonIgnore
    private Subadmin subadmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Subadmin getSubadmin() {
        return subadmin;
    }

    public void setSubadmin(Subadmin subadmin) {
        this.subadmin = subadmin;
    }

    

}
