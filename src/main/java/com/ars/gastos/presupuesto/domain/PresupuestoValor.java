package com.ars.gastos.presupuesto.domain;

public final class PresupuestoValor {
    private double monto;
    
    public PresupuestoValor(double monto) { 
        if (monto <= 0) {
            throw new PresupuestoValorIncorrectoExcepcion("El presupuesto no se ha establecido, debe ser mayor que 0");
        }
        this.monto = monto;
    }

    private PresupuestoValor() { }
}
