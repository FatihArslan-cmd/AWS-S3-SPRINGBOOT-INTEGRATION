package com.example.swe307_project2.Repository;

import com.example.swe307_project2.model.Emp;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    @EntityGraph(attributePaths = {"dept"})
    List<Emp> findAll();
}


