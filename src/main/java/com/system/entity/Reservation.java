package com.system.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
@Entity
public class Reservation {
	@Id
    private int reservationId;
    @Column(nullable = false)
    private int guestId;
    @Column(nullable = false)
    private int roomId;
    @Column(nullable = false)
    private Date checkInDate;
    @Column(nullable = false)
    private Date checkOutDate;
    @Column(nullable = false)
    private String status;

    // Constructor
    public Reservation(int reservationId, int guestId, int roomId, java.util.Date checkInDate2, java.util.Date checkOutDate2, String status) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = (Date) checkInDate2;
        this.checkOutDate = (Date) checkOutDate2;
        this.status = status;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
