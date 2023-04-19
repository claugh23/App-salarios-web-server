package com.example.empleadoswebserver.Repositories;

import com.example.empleadoswebserver.DTO.EmpleadosDTO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends MongoRepository<EmpleadosDTO,Long> {
}
