package com.system.serviceimp;

import com.system.Dao.GuestDao;
import com.system.daoimp.GuestDaoImpl;
import com.system.entity.Guest;
import com.system.service.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private GuestDao guestDao; // Dependency Injection of GuestDao
    
    public GuestServiceImpl() {
        this.guestDao = new GuestDaoImpl(); // Or any default initialization
    }

    // Constructor Injection (you can also use Setter Injection or Dependency Injection frameworks)
    public GuestServiceImpl(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public Guest addGuest(Guest guest) {
        // Delegate to DAO to add the guest
        return guestDao.addGuest(guest);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        // Delegate to DAO to update the guest
        return guestDao.updateGuest(guest);
    }

    @Override
    public String deleteGuest(int guestId) {
        // Delegate to DAO to delete the guest
        guestDao.deleteGuest(guestId);
		return null;
    }

    @Override
    public Guest getGuestById(int guestId) {
        // Delegate to DAO to retrieve a guest by ID
        return guestDao.getGuestById(guestId);
    }

    @Override
    public List<Guest> getAllGuests() {
        // Delegate to DAO to get all guests
        return guestDao.getAllGuests();
    }

	@Override
	public Guest addGuest(int guestId) {
		// TODO Auto-generated method stub
		return null;
	}
}
