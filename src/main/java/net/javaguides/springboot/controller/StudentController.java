package net.javaguides.springboot.controller;


import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("/student")
    public Student getStudent(){

        Student student = new Student(
                1,
                "cham",
                "mbk"
        );

        return student;

    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"key","mamba"));
        students.add(new Student(4, "baba", "camara"));

        return students;


    }

    // {id} - URI template variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name")String lastName) {
        return new Student(studentId, firstName, lastName);
    }

}
