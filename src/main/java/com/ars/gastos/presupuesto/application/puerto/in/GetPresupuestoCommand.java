package com.ars.gastos.presupuesto.application.puerto.in;

import com.ars.gastos.common.service.BeanValidation;

public final class GetPresupuestoCommand extends BeanValidation<GetPresupuestoCommand>{
    
    private GetPresupuestoRequest request;

    public GetPresupuestoCommand(GetPresupuestoRequest request) { 
        this.request = request; 
        this.autovalidar();
    }

    public GetPresupuestoRequest request() { return this.request; }
}
