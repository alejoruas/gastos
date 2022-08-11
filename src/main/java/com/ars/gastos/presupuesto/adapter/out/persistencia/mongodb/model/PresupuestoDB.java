package com.ars.gastos.presupuesto.adapter.out.persistencia.mongodb.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ars.gastos.presupuesto.domain.Presupuesto;

@Document("presupuesto")
public class PresupuestoDB {
    @Id
    private String id;

    private String nombre;
    private double valor;

    public PresupuestoDB() {}

    public PresupuestoDB(Presupuesto p) {
        id = p.id().valor();
        nombre = p.nombre().valor();
        valor = p.valor().valor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
