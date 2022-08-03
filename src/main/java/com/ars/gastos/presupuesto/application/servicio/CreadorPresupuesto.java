package com.ars.gastos.presupuesto.application.servicio;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoUseCase;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;
import com.ars.gastos.presupuesto.domain.PresupuestoNombre;
import com.ars.gastos.presupuesto.domain.PresupuestoValor;

public final class CreadorPresupuesto implements CreadorPresupuestoUseCase{
    private PresupuestoRepository repositorio;
    
    public CreadorPresupuesto(PresupuestoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public boolean crearPresupuesto(CreadorPresupuestoCommand command) {
        PresupuestoId id = new PresupuestoId(command.request().id());
        PresupuestoNombre nombre = new PresupuestoNombre(command.request().nombre());
        PresupuestoValor valor = new PresupuestoValor(command.request().valor());
        Presupuesto.create(id, nombre, valor, repositorio);
        return true;
    }
}
