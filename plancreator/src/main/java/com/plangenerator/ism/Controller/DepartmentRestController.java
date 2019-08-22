package com.plangenerator.ism.Controller;

import com.plangenerator.ism.Model.Department;
import com.plangenerator.ism.Repository.DepartmentRepository;
import com.plangenerator.ism.exceptions.RecordNotFoundException;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Irakli Kardava
 */
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentRestController {

    @Autowired
    private DepartmentRepository departmentRepository;


    Logger logger = LoggerFactory.getLogger(DepartmentRestController.class);


    /**
     *
     * @param id
     * @return Department json object
     */
    @GetMapping
    @ResponseBody
    public Department findById(@RequestParam(value = "id") int id) {
        logger.debug("**Department findById*", linkTo(methodOn(DepartmentRestController.class).findById(id)).withSelfRel());
        return departmentRepository.findAllByIdDepartment(id);
    }

    /**
     *
     * @param id
     * @return empty {@link ResponseEntity}
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteDepartment(@RequestParam(value = "id") int id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        Department department = findById(id);
        responseHeaders.set(department.getName(),
                "Is deleted");
        logger.debug("REST request to delete news : {}", id);
        departmentRepository.delete(findById(id));
        return ResponseEntity.ok().headers(responseHeaders).build();
    }

    /**
     *
     * @param idDepartment
     * @param departmentDetail
     * @return ResponseEntity ok
     * @throws RecordNotFoundException
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Department> updateDepartment(
            @RequestParam(value = "id") int idDepartment, @RequestBody Department departmentDetail)
            throws RecordNotFoundException {
        Department department =
                departmentRepository
                        .findById(idDepartment)
                        .orElseThrow(() -> new RecordNotFoundException(idDepartment));
        department.setAkronim(departmentDetail.getAkronim());
        department.setName(departmentDetail.getName());
        final Department updatedDepartment = departmentRepository.save(department);
        logger.debug("**Update Department**", linkTo(methodOn(DepartmentRestController.class).updateDepartment(idDepartment, departmentDetail)).withSelfRel());
        return ResponseEntity.ok(updatedDepartment);
    }

    /**
     *
     * @param departmentDetail
     * @return ResponseEntity<Department>
     * @throws RecordNotFoundException
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Department> saveDepartment(@RequestBody Department departmentDetail)
            throws RecordNotFoundException {
        logger.debug("**Update Department**", departmentDetail);
        return ResponseEntity.ok(departmentRepository.save(departmentDetail));
    }

}
