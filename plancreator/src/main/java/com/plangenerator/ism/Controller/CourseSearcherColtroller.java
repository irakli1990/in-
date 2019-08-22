package com.plangenerator.ism.Controller;


import com.plangenerator.ism.JsonClasses.Item;
import com.plangenerator.ism.Service.CourseSearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Irakli Kardava
 *
 */
@RestController
public class CourseSearcherColtroller {

    @Autowired
    private CourseSearcherService courseSearcherService;


    /**
     *
     * @param name
     * @return json Item object
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("name/{name}")
    public List<Item> getItems(@PathVariable String name) {
        return courseSearcherService.searchForCourse(name);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("code/{code}")
    public String getCourse(@PathVariable String code) {
        return courseSearcherService.searchForCourseByCode(code).toString();
    }
}
