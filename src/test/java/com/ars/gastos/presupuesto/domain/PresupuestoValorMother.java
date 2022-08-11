package com.ars.gastos.presupuesto.domain;

import java.util.Random;

public final class PresupuestoValorMother {
    public static PresupuestoValor create(double monto) { return new PresupuestoValor(monto); }

    public static PresupuestoValor random() {
        double min = 0d;
        double max = 100000000000d;

        Random random = new Random();
        return create(min + (max - min) * random.nextDouble());
    }
}
