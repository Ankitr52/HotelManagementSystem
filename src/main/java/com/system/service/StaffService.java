package com.system.service;

import com.system.entity.Staff;
import java.util.List;

public interface StaffService {
    Staff addStaff(Staff staff);
    Staff updateStaff(Staff staff);
    void deleteStaff(int staffId);
    Staff getStaffById(int staffId);
    List<Staff> getAllStaff();
}
