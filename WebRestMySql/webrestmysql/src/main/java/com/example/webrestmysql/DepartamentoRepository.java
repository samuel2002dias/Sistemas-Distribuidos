package com.example.webrestmysql;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called departamentoRepository
//CRUD refers Create, Read, Update, Delete

public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {

}
