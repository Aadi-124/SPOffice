package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
