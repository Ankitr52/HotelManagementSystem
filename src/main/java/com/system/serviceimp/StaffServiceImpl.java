package com.system.serviceimp;

import com.system.Dao.StaffDao;
import com.system.entity.Staff;
import com.system.service.StaffService;

import java.sql.Connection;
import java.util.List;

public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao; // Dependency Injection of StaffDao

    // Constructor Injection (can also use Setter Injection or Dependency Injection frameworks)
    public StaffServiceImpl(Connection connection) {
        this.staffDao = (StaffDao) connection;
    }

    @Override
    public Staff addStaff(Staff staff) {
        // Delegate to DAO to add the staff
        return staffDao.addStaff(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        // Delegate to DAO to update the staff
        return staffDao.updateStaff(staff);
    }

    @Override
    public void deleteStaff(int staffId) {
        // Delegate to DAO to delete the staff
        staffDao.deleteStaff(staffId);
    }

    @Override
    public Staff getStaffById(int staffId) {
        // Delegate to DAO to retrieve a staff by ID
        return staffDao.getStaffById(staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        // Delegate to DAO to get all staff
        return staffDao.getAllStaff();
    }
}
