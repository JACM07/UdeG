package org.example.udg.controllers;

import org.example.udg.Models.StudentModel;
import org.example.udg.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    //crear una instancia de Student service
    @Autowired
    StudentService studentService;

    //get
    @GetMapping()//es el mismo que getAllStudents          studentService.getAllStudent();
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    //post
    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //editar(put)
    @PutMapping()
    public StudentModel updateStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //delete
    @DeleteMapping()
    public String deleteStudentById(@RequestParam("id") Long id){
        return studentService.deleteStudent(id);
    }


    /*nuevo clase lunes
    @GetMapping("findStudentById/{id}")
    public Optional<StudentModel> findStudentModelById(@PathVariable Long id){
        return studentService.findStudentModelById(id);
    } */

    //buscar por código
    @GetMapping(path = "/find-by-code")//localhost:8080/student/find-by-code?
    public ArrayList<StudentModel> findByCode(@PathVariable String code){
        return studentService.findByCode(code);
    }

    //buscar por nombre
    @GetMapping(path = "/find-by-name")//localhost:8080/student/find-by-name?
    public ArrayList<StudentModel> findByName(@PathVariable String name){
        return studentService.findByName(name);
    }
}
