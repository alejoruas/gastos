package com.ars.gastos.presupuesto.application.servicio;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ars.gastos.common.service.Service;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoUseCase;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoId;
import com.ars.gastos.presupuesto.domain.PresupuestoNombre;
import com.ars.gastos.presupuesto.domain.PresupuestoValor;

@Service
@Component
public final class CreadorPresupuesto implements CreadorPresupuestoUseCase{
    private PresupuestoRepository repositorio;
    
    public CreadorPresupuesto(PresupuestoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Presupuesto crearPresupuesto(CreadorPresupuestoCommand command) {
        PresupuestoId id = new PresupuestoId(UUID.randomUUID().toString());
        PresupuestoNombre nombre = new PresupuestoNombre(command.request().nombre());
        PresupuestoValor valor = new PresupuestoValor(command.request().valor());        
        return Presupuesto.create(id, nombre, valor, repositorio);
    }
}
