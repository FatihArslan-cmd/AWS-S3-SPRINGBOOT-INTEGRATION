package com.example.swe307_project2.services;

import com.example.swe307_project2.Repository.EmpRepository;
import com.example.swe307_project2.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Emp> getAllEmployees() {
        return empRepository.findAll();
    }

    public Emp addEmployee(Emp emp) {
        return empRepository.save(emp);
    }

    public Emp updateEmployee(int empno, Emp empDetails) {
        Optional<Emp> optionalEmp = empRepository.findById(empno);
        if (optionalEmp.isPresent()) {
            Emp emp = optionalEmp.get();
            emp.setEname(empDetails.getEname());
            emp.setJob(empDetails.getJob());
            emp.setMgr(empDetails.getMgr());
            emp.setHiredate(empDetails.getHiredate());
            emp.setSal(empDetails.getSal());
            emp.setComm(empDetails.getComm());
            emp.setImg(empDetails.getImg());
            emp.setDept(empDetails.getDept());
            return empRepository.save(emp);
        }
        return null; // Handle this in the controller
    }

    public boolean deleteEmployee(int empno) {
        if (empRepository.existsById(empno)) {
            empRepository.deleteById(empno);
            return true;
        }
        return false;
    }

    // Add the missing getEmployeeById method
    public Emp getEmployeeById(int empno) {
        return empRepository.findById(empno).orElse(null);
    }
}
