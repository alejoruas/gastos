package com.ars.gastos.presupuesto.domain;

import com.ars.gastos.common.domain.StringValueObject;

public class PresupuestoNombre extends StringValueObject {

    public PresupuestoNombre(String valor) { super(valor); }

    private PresupuestoNombre() { super(""); }
    
}
