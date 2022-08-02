package com.ars.gastos.common.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identificador implements Serializable{
    final protected String valor;
    
    public Identificador(String valor) {
        esValidUuid(valor);
        this.valor = valor;        
    }

    protected Identificador() { this.valor = null; }

    public String Valor() { return this.valor; }

    private void esValidUuid(String valor) throws IllegalArgumentException {
        UUID.fromString(valor);
    }

    @Override
    public int hashCode() {        
        return Objects.hash(valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Identificador other = (Identificador) obj;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }    
}
