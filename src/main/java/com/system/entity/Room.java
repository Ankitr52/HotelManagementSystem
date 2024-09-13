package com.system.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Room {
	@Id	
	@Column(length = 10)
    private int roomId;
	@Column(nullable = false)
    private String roomNumber;
	@Column(nullable = false)
    private String roomType; // e.g., Single, Double, Suite
	@Column(nullable = false)
    private double pricePerNight;
	@Column(nullable = false)
    private String availabilityStatus; // e.g., Available, Occupied, Under Maintenance

    // Default constructor
    public Room() {
    	super();
    }
    

    // Parameterized constructor
    public Room(int roomId, String roomNumber, String roomType, double pricePerNight, String availabilityStatus) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                '}';
    }
}
