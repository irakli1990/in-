package com.plangenerator.ism.Repository;


import com.plangenerator.ism.Model.Department;
import com.plangenerator.ism.Model.Minimum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinimumRepository extends JpaRepository<Minimum,Integer> {

    Minimum findAllByDepartmentByDepertmentId(int id);
    Minimum findAllByIdMin(int id);

    void deleteMinimumByIdMin(int id);

    Minimum save(Department department);

}
