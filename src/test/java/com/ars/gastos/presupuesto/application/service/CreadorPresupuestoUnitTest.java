package com.ars.gastos.presupuesto.application.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;

public abstract class CreadorPresupuestoUnitTest {
    protected PresupuestoRepository repository;
    
    @BeforeEach
    protected void setup() {
        repository = mock(PresupuestoRepository.class);        
    }

    public void shouldHaveSaved(Presupuesto presupuesto) {
        verify(repository, atLeastOnce()).guardar(presupuesto);
    }
}
