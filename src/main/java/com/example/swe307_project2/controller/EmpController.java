package com.example.swe307_project2.controller;

import com.example.swe307_project2.model.Emp;
import com.example.swe307_project2.services.EmpService;
import com.example.swe307_project2.services.S3ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private S3ImageService s3ImageService;

    @GetMapping
    public List<Emp> getAllEmployees() {
        return empService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Emp> createEmployee(@RequestBody Emp emp) {
        Emp createdEmp = empService.addEmployee(emp);
        return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
    }

    @PutMapping("/{empno}")
    public ResponseEntity<Emp> updateEmployee(@PathVariable int empno, @RequestBody Emp empDetails) {
        Emp updatedEmp = empService.updateEmployee(empno, empDetails);
        if (updatedEmp != null) {
            return ResponseEntity.ok(updatedEmp);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{empno}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int empno) {
        // Fetch the employee to get the image URL
        Emp employee = empService.getEmployeeById(empno);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Extract the image key from the S3 URL
        String imgUrl = employee.getImg();
        String key = imgUrl.substring(imgUrl.lastIndexOf('/') + 1);

        // Delete the image from S3
        s3ImageService.deleteImage(key);

        // Delete the employee from the database
        boolean isDeleted = empService.deleteEmployee(empno);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
