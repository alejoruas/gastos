package com.ars.gastos.common.domain;

import java.util.Objects;

public abstract class StringValueObject {

    private String valor;

    public StringValueObject(String valor) { this.valor = valor; }

    public String valor() { return valor; }

    @Override
    public String toString() {
        return this.valor.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringValueObject other = (StringValueObject) obj;
        return Objects.equals(valor, other.valor);
    }   
}
