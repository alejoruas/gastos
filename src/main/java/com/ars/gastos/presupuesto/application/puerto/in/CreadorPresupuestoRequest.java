package com.ars.gastos.presupuesto.application.puerto.in;

public final class CreadorPresupuestoRequest {
    private String nombre;    
    private double valor;    

    public CreadorPresupuestoRequest(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String nombre() { return nombre; }

    public double valor() { return valor; }
}
