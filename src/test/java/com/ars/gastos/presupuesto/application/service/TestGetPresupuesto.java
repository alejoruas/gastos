package com.ars.gastos.presupuesto.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoRequest;
import com.ars.gastos.presupuesto.application.servicio.GetPresupuesto;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoMother;

public final class TestGetPresupuesto extends PresupuestoUnitTest{
    GetPresupuesto finder;

    @BeforeEach
    protected void setUp() {
        this.setup();
        finder = new GetPresupuesto(repository);
    }

    @Test
    void search_existing_presupuesto() {
        Presupuesto presupuesto = PresupuestoMother.random();

        GetPresupuestoRequest request = new GetPresupuestoRequest(presupuesto.id().valor());

        shouldSearch(presupuesto);

        GetPresupuestoCommand command = new GetPresupuestoCommand(request);

        Presupuesto respuesta = finder.getPresupuesto(command);

        assertEquals(presupuesto, respuesta);        
    }
}
