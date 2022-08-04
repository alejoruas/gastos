package com.ars.gastos.presupuesto.adapter.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoRequest;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoUseCase;

@RestController
public final class CreadorPresupuestoController {
    private CreadorPresupuestoUseCase creadorPresupuesto;

    public CreadorPresupuestoController(CreadorPresupuestoUseCase creadorPresupuesto) {
        this.creadorPresupuesto = creadorPresupuesto;
    }

    @PutMapping("/presupuesto")
    public ResponseEntity crearPresupuesto(@RequestBody Request request){
        CreadorPresupuestoRequest requestCommand 
            = new CreadorPresupuestoRequest(request.nombre(), request.valor());
        CreadorPresupuestoCommand command = new CreadorPresupuestoCommand(requestCommand);

        return new ResponseEntity(HttpStatus.CREATED);        
    }
}

/*
 * JSON que sirve de contrato para la entrada de lka información
 */
final class Request {
    private String nombre;
    private double valor;

    public String nombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double valor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }   
}
