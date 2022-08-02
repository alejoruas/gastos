package com.ars.gastos.presupuesto.domain;

public class PresupuestoValorIncorrectoExcepcion extends RuntimeException {
    public PresupuestoValorIncorrectoExcepcion(String mensaje) { super(mensaje); }
}
