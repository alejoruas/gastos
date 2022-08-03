package com.ars.gastos.presupuesto.domain;

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
        Presupuesto presupuesto = new Presupuesto(id, nombre, valor);

        repositorio.guardar(presupuesto);
        //TODO: generar evento de Presupuesto creado
        return presupuesto;
    }

    public PresupuestoId id() { return id; }

    public PresupuestoNombre nombre() { return nombre; }

    public PresupuestoValor valor() { return valor; }
    
}
