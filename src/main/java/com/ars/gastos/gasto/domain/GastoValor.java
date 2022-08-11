package com.ars.gastos.gasto.domain;

public final class GastoValor {
    private double valor;
    
    public GastoValor(double valor) { 
        if (valor <= 0) {
            throw new RuntimeException("El presupuesto no se ha establecido, debe ser mayor que 0");
        }
        this.valor = valor;
    }

    private GastoValor() { }

    public double valor() { return valor; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(valor);
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
        GastoValor other = (GastoValor) obj;
        if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
            return false;
        return true;
    }
}
