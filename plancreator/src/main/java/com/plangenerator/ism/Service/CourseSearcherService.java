package com.plangenerator.ism.Service;


import com.google.gson.Gson;
import com.plangenerator.ism.JsonClasses.CourseCodeSearcher;
import com.plangenerator.ism.JsonClasses.CourseSearcher;
import com.plangenerator.ism.JsonClasses.Item;
import com.plangenerator.ism.JsonClasses.Name;
import com.plangenerator.ism.JsonParser.CostumJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseSearcherService {


    private String searchUrl = "https://usosapps.us.edu.pl/services/courses/search?lang=pl&name=%s&fields=fac_id|name|ects_credits_simplified|course_id";


    private String codeSearchUrl = "https://usosapps.us.edu.pl/services/courses/course?course_id=%s&fields=id|name|fac_id|ects_credits_simplified";

    @Autowired
    private CostumJsonParser costumJsonParser;

    @Autowired
    private Gson gson;

    @Autowired
    private FacultyServisce facultyServisce;


    public List<Item> searchForCourse(String courseName) {

        Reader reader = costumJsonParser.
                parsUrltoJsonObject(String.format(searchUrl, URLEncoder.encode(courseName)));
        CourseSearcher courseSearcher = gson.fromJson(reader, CourseSearcher.class);
        List<Item> items = courseSearcher.getItems().stream()
                .map(temp -> {
                    Name name = new Name();
                    Item newitem = new Item();
                    name.setPl(temp.getName().getPl());
                    newitem.setName(name);
                    newitem.setFacId(temp.getFacId());
                    newitem.setCourseId(temp.getCourseId());
                    newitem.setEctsCreditsSimplified(temp.getEctsCreditsSimplified());
                    return newitem;
                })
                .collect(Collectors.toList());


        return items;
    }

    public CourseCodeSearcher searchForCourseByCode(String code) {

        Reader codeReader = costumJsonParser.parsUrltoJsonObject(String.format(codeSearchUrl, code));
        CourseCodeSearcher courseCodeSearcher = gson.fromJson(codeReader, CourseCodeSearcher.class);
//        System.out.println(courseCodeSearcher.getName().getPl());
        return courseCodeSearcher;
    }
}
