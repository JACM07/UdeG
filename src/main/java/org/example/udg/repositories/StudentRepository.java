package org.example.udg.repositories;

import org.example.udg.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    //editar
    //buscar por codigo
    public abstract ArrayList<StudentModel> findByCode(String code);
    //buscar por nombre
    public abstract  ArrayList<StudentModel> findByName(String name);

    //nuevo clase del lunes 11 marzo
    public Optional<StudentModel> getStudentModelByCode(String code);
    public Optional<StudentModel> findStudentModelById(Long id);
}
