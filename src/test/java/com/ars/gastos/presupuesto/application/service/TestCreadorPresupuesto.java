package com.ars.gastos.presupuesto.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoRequest;
import com.ars.gastos.presupuesto.application.servicio.CreadorPresupuesto;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoMother;

public final class TestCreadorPresupuesto extends CreadorPresupuestoUnitTest {
    CreadorPresupuesto creador;

    @BeforeEach
    protected void setup() {
        super.setup();
        creador = new CreadorPresupuesto(repository);
    }

    @Test
    void save_valid_course() {      
        
        Presupuesto presupuesto = PresupuestoMother.random();

        CreadorPresupuestoRequest request = 
            new CreadorPresupuestoRequest(
                presupuesto.id().Valor(), 
                presupuesto.nombre().valor(), 
                presupuesto.valor().valor());

        CreadorPresupuestoCommand command = new CreadorPresupuestoCommand(request);

        creador.crearPresupuesto(command);

        shouldHaveSaved(presupuesto);
    }
}
