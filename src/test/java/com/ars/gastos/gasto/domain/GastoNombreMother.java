package com.ars.gastos.gasto.domain;

import com.ars.gastos.common.domain.RandomString;

public final class GastoNombreMother {
    public static GastoNombre create(String nombre) { return new GastoNombre(nombre); }

    public static GastoNombre random() { 
        RandomString randomString = new RandomString(100);
        return create(randomString.nextString()); 
    }
}
