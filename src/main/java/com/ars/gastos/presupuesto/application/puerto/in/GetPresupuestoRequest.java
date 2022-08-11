package com.ars.gastos.presupuesto.application.puerto.in;

public final class GetPresupuestoRequest {
    private String id;

    public GetPresupuestoRequest(String id) { this.id = id; }

    public String id() { return this.id; }
}
