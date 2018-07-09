package com.andvicente.springboot2rest.cucumber.steps;

import com.andvicente.springboot2rest.student.Student;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class EstudanteSteps {

    Student estudante = new Student();
    Response responseProcurarEstudante;

    @Dado("um estudante com {long}")
    public void um_estudante_com(final Long codigoEstudante) {
        this.estudante.setId(codigoEstudante);
    }

    @Quando("eu procurar pelo estudante")
    public void procurarEstudante(){
        this.responseProcurarEstudante = when().
                get("/students/"+this.estudante.getId()).then().extract().response();
        this.responseProcurarEstudante.prettyPrint();

    }

    @Entao ("o status da consulta sera {int}")
    public void o_status_da_consulta_sera(int status) {
        assertEquals(this.responseProcurarEstudante.getStatusCode(),status);
    }


    @Dado("^novos estudantes cadastrados$")
    public void novosEstudantesCadastrados()  {
        List <Student> students = new ArrayList<>();
        students.add(new Student(1L,"ANDRE","E1234567"));
        students.add(new Student(2L,"RONALDO","A768905"));

        for(Student student : students){
            given().
                    body(student).contentType(ContentType.JSON).
            when().
                    post("/students/").then().statusCode(201);
        }
    }
}
