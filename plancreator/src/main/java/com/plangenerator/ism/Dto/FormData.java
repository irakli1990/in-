package com.plangenerator.ism.Dto;

public class FormData {
    private String name;
    private String surName;
    private String teacher;
    private String year;
    private String albumNumber;
    private String semester;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(String albumNumber) {
        this.albumNumber = albumNumber;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", year='" + year + '\'' +
                ", albumNumber='" + albumNumber + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
