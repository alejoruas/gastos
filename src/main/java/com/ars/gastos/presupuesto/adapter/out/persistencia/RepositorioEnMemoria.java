package com.ars.gastos.presupuesto.adapter.out.persistencia;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ars.gastos.common.service.Service;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;

//@Service
//@Component
public final class RepositorioEnMemoria implements PresupuestoRepository{

    private HashMap<String, Presupuesto> presupuestos = new HashMap<>();

    public RepositorioEnMemoria() {}

    @Override
    public Presupuesto save(Presupuesto presupuesto) {        
        this.presupuestos.put(presupuesto.id().valor(), presupuesto);
        return presupuesto;
    }

    @Override
    public Optional<Presupuesto> searchById(String id) {        
        return Optional.ofNullable(presupuestos.get(id));
    }    
}
