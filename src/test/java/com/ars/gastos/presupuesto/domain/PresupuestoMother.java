package com.ars.gastos.presupuesto.domain;

import java.util.UUID;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoRequest;

public final class PresupuestoMother {
    
    public static Presupuesto create(PresupuestoId id, PresupuestoNombre nombre, PresupuestoValor valor) {
        return new Presupuesto(id, nombre, valor);
    }

    public static Presupuesto fromRequest(CreadorPresupuestoRequest request) {
        return create(
            PresupuestoIdMother.create(UUID.randomUUID().toString()),
            PresupuestoNombreMother.create(request.nombre()),
            PresupuestoValorMother.create(request.valor())
        );
    }

    public static Presupuesto random() {
        return create(
            PresupuestoIdMother.createRandom(),
            PresupuestoNombreMother.random(),
            PresupuestoValorMother.random()
        );
    }
}
