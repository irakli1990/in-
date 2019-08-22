package com.plangenerator.ism.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    private int idDepartment;
    private String name;
    private String akronim;
    private Collection<Minimum> minimumsByIdDepartment;

    @Id
    @Column(name = "id_department", nullable = false)
    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "akronim", nullable = true, length = 45)
    public String getAkronim() {
        return akronim;
    }

    public void setAkronim(String akronim) {
        this.akronim = akronim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return idDepartment == that.idDepartment &&
                Objects.equals(name, that.name) &&
                Objects.equals(akronim, that.akronim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, name, akronim);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "departmentByDepertmentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Minimum> getMinimumsByIdDepartment() {
        return minimumsByIdDepartment;
    }

    public void setMinimumsByIdDepartment(Collection<Minimum> minimumsByIdDepartment) {
        this.minimumsByIdDepartment = minimumsByIdDepartment;
    }
}
