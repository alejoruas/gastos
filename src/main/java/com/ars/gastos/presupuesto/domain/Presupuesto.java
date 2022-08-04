package com.ars.gastos.presupuesto.domain;

import java.util.UUID;

import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;

public final class Presupuesto {
    
    private final PresupuestoId id;
    private final PresupuestoNombre nombre;
    private final PresupuestoValor valor;

    private Presupuesto() {
        this.id = null;
        this.nombre = null;
        this.valor = null;
    }

    public Presupuesto(PresupuestoId id, PresupuestoNombre nombre, PresupuestoValor valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public static Presupuesto create(PresupuestoId id, PresupuestoNombre nombre, PresupuestoValor valor, PresupuestoRepository repositorio) {
        Presupuesto presupuesto = new Presupuesto(new PresupuestoId(UUID.randomUUID().toString()), nombre, valor);

        repositorio.guardar(presupuesto);
        //TODO: generar evento de Presupuesto creado
        return presupuesto;
    }

    public PresupuestoId id() { return id; }

    public PresupuestoNombre nombre() { return nombre; }

    public PresupuestoValor valor() { return valor; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Presupuesto other = (Presupuesto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
