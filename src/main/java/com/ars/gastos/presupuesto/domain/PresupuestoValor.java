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

    public double valor() { return monto; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(monto);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PresupuestoValor other = (PresupuestoValor) obj;
        if (Double.doubleToLongBits(monto) != Double.doubleToLongBits(other.monto))
            return false;
        return true;
    }

    
}
