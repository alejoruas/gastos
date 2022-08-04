package com.ars.gastos.presupuesto.adapter.out.persistencia;

import java.util.HashMap;
import java.util.Optional;

import com.ars.gastos.common.service.Service;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;

@Service
public final class RepositorioEnMemoria implements PresupuestoRepository{

    private HashMap<String, Presupuesto> presupuestos = new HashMap<>();

    @Override
    public void guardar(Presupuesto presupuesto) {
        this.presupuestos.put(presupuesto.id().Valor(), presupuesto);
    }

    @Override
    public Optional<Presupuesto> buscar(PresupuestoId id) {        
        return Optional.ofNullable(presupuestos.get(id.Valor()));
    }    
}
