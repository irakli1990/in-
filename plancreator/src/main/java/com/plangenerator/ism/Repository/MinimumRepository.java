package com.plangenerator.ism.Repository;


import com.plangenerator.ism.Model.Department;
import com.plangenerator.ism.Model.Minimum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinimumRepository extends JpaRepository<Minimum,Integer> {

    Minimum findAllByIdDepartment(int id);

    void deleteMinimumById(int id);

    Minimum save(Department department);

}
