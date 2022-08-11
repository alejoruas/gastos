package com.ars.gastos.gasto.domain;

import java.util.Random;

public final class GastoValorMother {
    public static GastoValor create(double valor) { return new GastoValor(valor); }

    public static GastoValor random() {
        double min = -100000000000d;
        double max = 100000000000d;

        Random random = new Random();
        return create(min + (max - min) * random.nextDouble());
    }
}
