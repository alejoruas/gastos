package com.ars.gastos.presupuesto.application.puerto.in;

public final class CreadorPresupuestoRequest {
    private String id;
    private String nombre;    
    private double valor;    

    public CreadorPresupuestoRequest(String id, String nombre, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String id() { return id; }

    public String nombre() { return nombre; }

    public double valor() { return valor; }
}
