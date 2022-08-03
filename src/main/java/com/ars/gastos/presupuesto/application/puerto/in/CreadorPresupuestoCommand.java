package com.ars.gastos.presupuesto.application.puerto.in;

import javax.validation.constraints.NotNull;

import com.ars.gastos.common.service.BeanValidation;

public class CreadorPresupuestoCommand extends BeanValidation<CreadorPresupuestoCommand>{
    
    @NotNull
    private final CreadorPresupuestoRequest request;

    public CreadorPresupuestoCommand(CreadorPresupuestoRequest request) {
        this.request = request;
        this.autovalidar();
    }

    public CreadorPresupuestoRequest request() { return this.request; }
}
