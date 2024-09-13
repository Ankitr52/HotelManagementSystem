package com.system.Dao;

import com.system.entity.Staff;
import java.util.List;

public interface StaffDao {
    Staff addStaff(Staff staff);
    Staff updateStaff(Staff staff);
    void deleteStaff(int staffId);
    Staff getStaffById(int staffId);
    List<Staff> getAllStaff();
}
