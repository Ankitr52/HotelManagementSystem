package com.system.service;

import com.system.entity.Guest;
import java.util.List;

public interface GuestService {
    Guest addGuest(int guestId);
    Guest updateGuest(Guest guest);
    String deleteGuest(int guestId);
    Guest getGuestById(int guestId);
    List<Guest> getAllGuests();
	Guest addGuest(Guest guest);
}
