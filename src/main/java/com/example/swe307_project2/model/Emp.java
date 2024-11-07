package com.example.swe307_project2.model;

import jakarta.persistence.*;

@Entity
public class Emp {

    @Id
    private int empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hiredate;

    private int sal;
    private Integer comm;
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loading
    @JoinColumn(name = "deptno", referencedColumnName = "deptno", insertable = false, updatable = false)
    private Dept dept;

    // Additional field for deptno
    @Column(name = "deptno", insertable = true, updatable = true)
    private Integer deptno;

    // Getters and setters

    // empno getter and setter
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    // ename getter and setter
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    // job getter and setter
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // mgr getter and setter
    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    // hiredate getter and setter
    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    // sal getter and setter
    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    // comm getter and setter
    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    // img getter and setter
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    // dept getter and setter
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    // deptno getter
    public Integer getDeptno() {
        return dept != null ? dept.getDeptno() : null;
    }
}
