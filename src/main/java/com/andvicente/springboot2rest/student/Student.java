package com.andvicente.springboot2rest.student;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Student Identification (ID)")
    private Long id;
    @ApiModelProperty(notes = "Student Complete Name")
    private String name;
    @ApiModelProperty(notes = "Student Passport Number")
    private String passportNumber;

    public Student() {
        super();
    }

    public Student(Long id, String name, String passportNumber) {
        super();
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(passportNumber, student.passportNumber);
    }

    @Override public int hashCode() {

        return Objects.hash(id, name, passportNumber);
    }

    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

}