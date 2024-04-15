package org.example.udg.services;

import org.example.udg.Models.StudentModel;
import org.example.udg.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //obtener todos los estudiantes registrados
    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    //guardar un estudiante
    public StudentModel saveStudent(StudentModel studentModel){
        //llamar a getStudentByID
        if(studentRepository.getStudentModelByCode(studentModel.getCode()).isEmpty()){//Nuevo clase lunes
            return studentRepository.save(studentModel);
        }else{
            //retornar un error de repetido
            StudentModel studentError=new StudentModel();
            studentError.setId(-1L);
            return studentError;
        }
    }

    //buscar por nombre
    public ArrayList<StudentModel> findByName(String name){
        return studentRepository.findByName(name);
    }

    //buscar por código
    public ArrayList<StudentModel> findByCode(String code){
        return studentRepository.findByCode(code);
    }

    /*por id
    public ArrayList<StudentModel> findStudentModelById(Long id){
        return studentRepository.findStudentModelById(id);
    }*/

    //Eliminar student
    public String deleteStudent(Long id){
        //primero vamos a buscar si exite un estudiante con ese id
        Optional<StudentModel> respuesta=studentRepository.findById(id);
        if(respuesta.isPresent()){
            studentRepository.findById(id);
            return "Estudiante eliminado";
        }
        else{
            return "No se encontró un estudiante con ese código";
        }
    }

    //public StudentModel editById()
}
