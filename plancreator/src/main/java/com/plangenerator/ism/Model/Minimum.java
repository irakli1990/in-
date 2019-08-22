package com.plangenerator.ism.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Minimum {
    private int idMin;
    private String major;
    private String level;
    private String note;
    private int depertmentId;
    private Department departmentByDepertmentId;

    @Id
    @Column(name = "id_min", nullable = false)
    public int getIdMin() {
        return idMin;
    }

    public void setIdMin(int idMin) {
        this.idMin = idMin;
    }

    @Basic
    @Column(name = "major", nullable = false, length = 255)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "level", nullable = true, length = 11)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 255)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "depertment_id", nullable = false, insertable = false, updatable = false)
    public int getDepertmentId() {
        return depertmentId;
    }

    public void setDepertmentId(int depertmentId) {
        this.depertmentId = depertmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minimum minimum = (Minimum) o;
        return idMin == minimum.idMin &&
                depertmentId == minimum.depertmentId &&
                Objects.equals(major, minimum.major) &&
                Objects.equals(level, minimum.level) &&
                Objects.equals(note, minimum.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMin, major, level, note, depertmentId);
    }

    @ManyToOne
    @JoinColumn(name = "depertment_id", referencedColumnName = "id_department", nullable = false)
    public Department getDepartmentByDepertmentId() {
        return departmentByDepertmentId;
    }

    public void setDepartmentByDepertmentId(Department departmentByDepertmentId) {
        this.departmentByDepertmentId = departmentByDepertmentId;
    }
}
