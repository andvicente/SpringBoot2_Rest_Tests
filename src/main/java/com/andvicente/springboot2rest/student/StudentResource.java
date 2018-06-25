package com.andvicente.springboot2rest.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value="Students Register", description="Operations in a Students Register")
public class StudentResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    @ApiOperation("RETRIEVE All Students Registered")
    public List<Student> retrieveAllStudents() {
        logger.debug("Retrieving all students");
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    @ApiOperation("RETRIEVE Student using ID")
    public Student retrieveStudent(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()) {
            throw new StudentNotFoundException(String.format("Student %d not found", id));
        }


        return student.get();
    }

    @GetMapping("/students/passport/{passport}")
    @ApiOperation("RETRIEVE Student using his/her Passport ID")
    public List<Student> retrieveStudentUsingPassport(@PathVariable String passport) {

        List<Student> student = studentRepository.findByPassportNumber(passport);
        if (student.size()==0) {
            throw new StudentNotFoundException(String.format("Student with passport %s not found", passport));
        }
        return student;
    }

    @DeleteMapping("/students/{id}")
    @ApiOperation("REMOVE Student using ID")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        logger.debug("Student {} removed ", id);
    }

    @PostMapping("/students")
    @ApiOperation("REGISTER a NEW Student")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/students/{id}")
    @ApiOperation("UPDATE Student Information")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);

        studentRepository.save(student);

        return ResponseEntity.noContent().build();
    }
}