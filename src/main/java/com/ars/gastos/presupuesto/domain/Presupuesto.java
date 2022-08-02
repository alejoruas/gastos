package com.ars.gastos.presupuesto.domain;

public final class Presupuesto {
    
    private final PresupuestoId id;

    private Presupuesto() {
        this.id = null;
    }

    public Presupuesto(PresupuestoId id) {
        this.id = id;
    }

    public static Presupuesto create(PresupuestoId id) {
        Presupuesto presupuesto = new Presupuesto(id);

        //TODO: Guardar en el repositorio
        //TODO: generar evento de Presupuesto creado
        return presupuesto;
    }
}
