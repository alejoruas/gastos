package com.ars.gastos.presupuesto.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoRequest;
import com.ars.gastos.presupuesto.application.servicio.CreadorPresupuesto;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoNombreMother;

public final class TestCreadorPresupuesto extends PresupuestoUnitTest {
    CreadorPresupuesto creador;

    @BeforeEach
    protected void setup() {
        super.setup();
        creador = new CreadorPresupuesto(repository);
    }

    @Test
    void save_valid_presupuesto() {            
        
        CreadorPresupuestoRequest request = 
            new CreadorPresupuestoRequest( 
                PresupuestoNombreMother.random().valor(), 
                600000d);

        CreadorPresupuestoCommand command = new CreadorPresupuestoCommand(request);

        Presupuesto presupuesto = creador.crearPresupuesto(command);

        shouldHaveSaved(presupuesto);
    }
}
