package com.plangenerator.ism.Service;


import com.google.gson.Gson;
import com.plangenerator.ism.JsonClasses.Faculties;
import com.plangenerator.ism.JsonParser.CostumJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Reader;

@Service
public class FacultyServisce {


    @Autowired
    private CostumJsonParser costumJsonParser;


    @Autowired
    private Gson gson;

    @Value("${spring.faculty.search.address}")
    private String facultySearchUrl;


    public String searchForFacultyName(String facultyID) {
        Reader reader = costumJsonParser.
                parsUrltoJsonObject(String.format(facultySearchUrl,facultyID));
        Faculties facultySearcher = gson.fromJson(reader, Faculties.class);
        return facultySearcher.getName().getPl();
    }

}
