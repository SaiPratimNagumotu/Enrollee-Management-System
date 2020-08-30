package com.example.demo.repository;

import com.example.demo.model.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {
    @Query(value = "SELECT * FROM enrollees WHERE activation_status = :status", nativeQuery = true)
    List<Enrollee> findByActivation_status(@Param("status") boolean status);
}
