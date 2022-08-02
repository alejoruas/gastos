package com.ars.gastos.presupuesto.domain;

import com.ars.gastos.common.domain.RandomString;

public final class PresupuestoNombreMother {
    public static PresupuestoNombre create(String nombre) { return new PresupuestoNombre(nombre); }

    public static PresupuestoNombre random() { 
        RandomString randomString = new RandomString(100);
        return create(randomString.nextString()); 
    }
}
