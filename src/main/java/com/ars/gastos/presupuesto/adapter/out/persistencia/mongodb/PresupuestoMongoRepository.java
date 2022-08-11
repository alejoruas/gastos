package com.ars.gastos.presupuesto.adapter.out.persistencia.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ars.gastos.presupuesto.adapter.out.persistencia.mongodb.model.PresupuestoDB;

public interface PresupuestoMongoRepository extends MongoRepository<PresupuestoDB, String>{
    
}
