package com.andvicente.springboot2rest.restassured;

import com.andvicente.springboot2rest.student.Student;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class StudentTests {

    @Test
    public void listAllStudents() {

        when().
                get("/students").
        then().
                body("name[0]", is("Ranga")).
                body("name[1]",is("Ravi"));

    }

    @Test
    public void updateStudent(){
        Student student= new Student(10001L,"ANDRE","E1234567");
        Student studentError= new Student(100L,"ANDRE2","E1234567");

        given()
                .body(student).contentType(ContentType.JSON).
        when().
                put("/students/" + student.getId()).
        then().statusCode(204);

        verifyStudent(student);
    }

    @Test
    public void retrieveStudentNotFound(){
        when().
                get("/students/1002").
        then().statusCode(404);
    }

    @Test
    public void registerStudent(){

    }

    @Test
    public void removeStudent(){

    }

    private void verifyStudent(Student student) {
        Student body = when().get("/students/"+student.getId()).
                as(Student.class);
        assertEquals(body,student);
    }

}