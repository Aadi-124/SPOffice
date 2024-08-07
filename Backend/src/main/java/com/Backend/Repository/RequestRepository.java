package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
