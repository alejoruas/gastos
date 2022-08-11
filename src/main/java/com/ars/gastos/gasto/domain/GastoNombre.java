package com.ars.gastos.gasto.domain;

import com.ars.gastos.common.domain.StringValueObject;

public final class GastoNombre extends StringValueObject{
    public GastoNombre(String valor) { super(valor); }

    private GastoNombre() { super(""); }
}
