package com.system.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Guest {
	@Id	
	@Column(length = 10)
    private int guestId;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String phone;
	@Column(nullable = false)
    private String address;
	@Column(nullable = false)
    private String identificationNumber;

    // Constructor
    public Guest(int guestId, String name, String email, String phone, String address, String identificationNumber) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.identificationNumber = identificationNumber;
    }

    // Getters
    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
