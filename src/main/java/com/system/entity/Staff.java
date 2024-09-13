package com.system.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Staff {
	@Id	
	@Column(length = 10)
    private int staffId;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String position;
	@Column(nullable = false)
    private double salary;
	@Column(nullable = false)
    private Date hireDate;

    // Constructor
    public Staff(int staffId, String name, String position, double string, Date string2) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
        this.salary = string;
        this.hireDate = string2;
    }

    public Staff(int staffId2, String name2, String position2, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
