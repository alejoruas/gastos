package com.ars.gastos.gasto.domain;

import java.util.UUID;

public final class GastoIdMother {
    public static GastoId create(String id) { return new GastoId(id); }

    public static GastoId createRandom() { return create(UUID.randomUUID().toString()); }
}
