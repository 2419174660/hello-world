package com.imooc.sm.service.impl;

import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("StaffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public void add(Staff staff) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void edit(Staff staff) {

    }

    @Override
    public Staff selectById(Integer id) {
        return null;
    }

    @Override
    public List<Staff> selectAll() {
        return null;
    }
}
