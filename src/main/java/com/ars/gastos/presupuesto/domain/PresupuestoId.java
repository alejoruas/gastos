package com.ars.gastos.presupuesto.domain;

import com.ars.gastos.common.domain.Identificador;

public final class PresupuestoId extends Identificador {
    
    public PresupuestoId(String id) { super(id); }

    private PresupuestoId() { super(null); }
}
