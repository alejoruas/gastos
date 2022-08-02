package com.ars.gastos.presupuesto.domain;

import java.util.UUID;

public final class PresupuestoIdMother {
    
    public static PresupuestoId create(String id) { return new PresupuestoId(id); }

    public static PresupuestoId createRandom() { return create(UUID.randomUUID().toString()); }
}
