package com.ars.gastos.gasto.domain;

import com.ars.gastos.presupuesto.domain.PresupuestoId;

public final class Gasto {
    private final GastoId id;
    private final PresupuestoId idPresupuesto;
    private final GastoNombre nombre;
    private final GastoValor valor;

    public Gasto(GastoId id, PresupuestoId idPresupuesto, GastoNombre nombre, GastoValor valor) {
        this.id = id;
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.valor = valor;
    }

    private Gasto() {
        this.id = null;
        this.idPresupuesto = null;
        this.nombre = null;
        this.valor = null;
    }

    public static Gasto create(GastoId id, PresupuestoId idPresupuesto, GastoNombre nombre, GastoValor valor) {
        Gasto gasto = new Gasto(id, idPresupuesto, nombre, valor);
        return gasto;
    }

    public GastoId id() { return id; }

    public PresupuestoId idPresupuesto() { return idPresupuesto; }

    public GastoNombre nombre() { return nombre; }

    public GastoValor valor() { return valor; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idPresupuesto == null) ? 0 : idPresupuesto.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
        Gasto other = (Gasto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (idPresupuesto == null) {
            if (other.idPresupuesto != null)
                return false;
        } else if (!idPresupuesto.equals(other.idPresupuesto))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

    
}
