package com.plangenerator.ism.Repository;


import com.plangenerator.ism.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    Department findAllByIdDepartment(int id);

    void deleteAllByIdDepartment(int id);

    Department save(Department department);
}
