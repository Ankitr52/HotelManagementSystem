package com.system.service;

import com.system.entity.Room;
import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    Room updateRoom(Room room);
    String deleteRoom(int roomIdToDelete);
    Room getRoomById(int roomIdToUpdate);
    List<Room> getAllRooms();
	Room getRoomById(String roomNumber);
	String deleteRoom(String number);
}
