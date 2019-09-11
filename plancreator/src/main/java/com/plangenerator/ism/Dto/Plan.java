package com.plangenerator.ism.Dto;

public class Plan {
    private String department;
    private String major;
    private String subjectName;
    private String practics;
    private String classRom;
    private String group;
    private String teacher;
    private String code;
    private String ects;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getPractics() {
        return practics;
    }

    public void setPractics(String practics) {
        this.practics = practics;
    }

    public String getClassRom() {
        return classRom;
    }

    public void setClassRom(String classRom) {
        this.classRom = classRom;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", practics='" + practics + '\'' +
                ", classRom='" + classRom + '\'' +
                ", group='" + group + '\'' +
                ", teacher='" + teacher + '\'' +
                ", code='" + code + '\'' +
                ", ects='" + ects + '\'' +
                '}';
    }
}
