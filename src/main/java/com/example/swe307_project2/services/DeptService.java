package com.example.swe307_project2.services;

import com.example.swe307_project2.Repository.DeptRepository;
import com.example.swe307_project2.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> getAllDepartments() {
        return deptRepository.findAll();
    }
}
