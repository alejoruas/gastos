package com.ars.gastos.gasto.domain;

import com.ars.gastos.common.domain.Identificador;

public final class GastoId extends Identificador{
    public GastoId(String id) { super(id); }

    private GastoId() { super(null); }
}
