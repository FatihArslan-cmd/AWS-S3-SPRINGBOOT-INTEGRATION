package com.example.swe307_project2.Repository;

import com.example.swe307_project2.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
