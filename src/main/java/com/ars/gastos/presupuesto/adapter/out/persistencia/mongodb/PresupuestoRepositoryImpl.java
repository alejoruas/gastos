package com.ars.gastos.presupuesto.adapter.out.persistencia.mongodb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ars.gastos.common.service.GenericServiceDBImpl;
import com.ars.gastos.common.service.Service;
import com.ars.gastos.presupuesto.adapter.out.persistencia.mongodb.model.PresupuestoDB;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;
import com.ars.gastos.presupuesto.domain.PresupuestoNombre;
import com.ars.gastos.presupuesto.domain.PresupuestoValor;

@Service
@Component
public class PresupuestoRepositoryImpl extends GenericServiceDBImpl<Presupuesto, String> implements PresupuestoRepository {

    @Autowired
    private PresupuestoMongoRepository mongoRepository;

    @Override
    public CrudRepository<Presupuesto, String> getDao() {
        return null;
    }

    @Override
    public Presupuesto save(Presupuesto entity) {
        PresupuestoDB pp = new PresupuestoDB(entity);
        pp = mongoRepository.save(pp);
        return entity;
    }  
    
    @Override
    public Optional<Presupuesto> searchById(String id) {
        PresupuestoDB pp = mongoRepository.findById(id).get();
        if (pp != null) {
            Presupuesto presupuesto = new Presupuesto(
                new PresupuestoId(pp.getId()), 
                new PresupuestoNombre(pp.getNombre()), 
                new PresupuestoValor(pp.getValor()));

                return Optional.of(presupuesto);
        }
        return null;
    }
}
