package com.system.serviceimp;

import com.system.entity.Room;
import com.system.service.RoomService;
import com.system.Dao.RoomDao;
import com.system.daoimp.RoomDaoImpl;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao; // Add a RoomDao instance

    public RoomServiceImpl() {
        this.roomDao = new RoomDaoImpl(); // Initialize the RoomDao instance
    }

    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room); // Delegate to RoomDao
    }

    @Override
    public Room updateRoom(Room room) {
        roomDao.updateRoom(room); // Delegate to RoomDao
        return room; // Return the updated room
    }

    @Override
    public String deleteRoom(String number) {
        // You might need to convert room number to ID or handle it accordingly
        // For simplicity, assuming 'number' is the room ID
        roomDao.deleteRoom(Integer.parseInt(number));
        return "Room deleted"; // Return a message or status
    }

    @Override
    public Room getRoomById(String roomNumber) {
        return roomDao.getRoomById(Integer.parseInt(roomNumber)); // Convert roomNumber to ID and fetch the room
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDao.getAllRooms(); // Delegate to RoomDao to fetch all rooms
    }

	@Override
	public Room getRoomById(int roomIdToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRoom(int roomIdToDelete) {
		// TODO Auto-generated method stub
		return null;
	}
}
