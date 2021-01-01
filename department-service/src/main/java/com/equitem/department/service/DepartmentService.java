package com.equitem.department.service;

import com.equitem.department.entity.Department;
import com.equitem.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
//        Logger log = null;
//        log.info("Inside the saveDepartment method in DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
//        Logger log = null;
//        log.info("Inside the saveDepartment method in DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
