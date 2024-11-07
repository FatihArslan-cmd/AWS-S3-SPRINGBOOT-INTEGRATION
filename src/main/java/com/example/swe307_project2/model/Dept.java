package com.example.swe307_project2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dept {

    @Id
    private int deptno;
    private String dname;
    private String loc;

    // Getter ve Setter metodları

    // deptno için getter ve setter
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    // dname için getter ve setter
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    // loc için getter ve setter
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
