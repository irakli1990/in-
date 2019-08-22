package com.plangenerator.ism.Service;


import com.plangenerator.ism.Model.Department;
import com.plangenerator.ism.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }


    public int countDepartment() {
        return getDepartmentList().size();
    }

    public Department getDepartmentByid(int idDepartment) {
        return departmentRepository.getOne(idDepartment);
    }


    public Department saveDepartment(Department department) {
        department.setAkronim(department.getAkronim());
        department.setName(department.getName());

        return departmentRepository.save(department);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}


