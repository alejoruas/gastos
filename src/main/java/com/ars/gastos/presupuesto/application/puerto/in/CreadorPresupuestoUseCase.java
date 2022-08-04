package com.ars.gastos.presupuesto.application.puerto.in;

import com.ars.gastos.presupuesto.domain.Presupuesto;

public interface CreadorPresupuestoUseCase {
    Presupuesto crearPresupuesto(CreadorPresupuestoCommand command);  
}
