package com.example.webrestmysql;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository

//CRUD refers Create, Read, Update, Delete
public interface AlunoRepository extends
                CrudRepository<Aluno, Integer> {

        Aluno findById(int id);

        Aluno deleteById(int id);
                
}