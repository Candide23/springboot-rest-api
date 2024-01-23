package net.javaguides.springboot.controller;


import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    // spring boot REST API with Request Param

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam  String lastName){
        return new Student(id, firstName, lastName);

    }

    // spring boot REST API that handles HTTP POSTRequest
    // @PostMapping and @RequesBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;



    }

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }


}
