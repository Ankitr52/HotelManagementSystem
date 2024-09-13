package com.system.Dao;

import com.system.entity.Room;
import java.util.List;

public interface RoomDao {
    // Method to add a new room to the database
    void addRoom(Room room);

    // Method to update an existing room in the database
    void updateRoom(Room room);

    // Method to delete a room by its ID
    void deleteRoom(int roomId);

    // Method to fetch a room by its ID
    Room getRoomById(int roomId);

    // Method to fetch all rooms
    List<Room> getAllRooms();
}
