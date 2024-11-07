package com.example.swe307_project2.controller;

import com.example.swe307_project2.model.Dept;
import com.example.swe307_project2.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public List<Dept> getAllDepartments() {
        return deptService.getAllDepartments();
    }
}
