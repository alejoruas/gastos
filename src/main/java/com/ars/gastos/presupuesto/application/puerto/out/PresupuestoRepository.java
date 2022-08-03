package com.ars.gastos.presupuesto.application.puerto.out;

import java.util.Optional;

import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;

public interface PresupuestoRepository {
    
    void guardar(Presupuesto presupuesto);

    Optional<Presupuesto> buscar(PresupuestoId id);
}
