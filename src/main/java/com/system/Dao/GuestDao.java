package com.system.Dao;

import com.system.entity.Guest;
import java.util.List;

public interface GuestDao {
    Guest addGuest(Guest guest);
    Guest updateGuest(Guest guest);
    void deleteGuest(int guestId);
    Guest getGuestById(int guestId);
    List<Guest> getAllGuests();
}
