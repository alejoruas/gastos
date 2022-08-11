package com.ars.gastos.presupuesto.adapter.in.apirest;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoRequest;
import com.ars.gastos.presupuesto.application.puerto.in.CreadorPresupuestoUseCase;
import com.ars.gastos.presupuesto.domain.Presupuesto;

@RestController
public final class CreadorPresupuestoController {
    private final CreadorPresupuestoUseCase creadorPresupuesto;

    public CreadorPresupuestoController(CreadorPresupuestoUseCase creadorPresupuesto) {
        this.creadorPresupuesto = creadorPresupuesto;
    }

    @PostMapping("/presupuesto")
    public ResponseEntity crearPresupuesto(@RequestBody Request request){
        CreadorPresupuestoRequest requestCommand 
            = new CreadorPresupuestoRequest(request.nombre(), request.valor());
        CreadorPresupuestoCommand command = new CreadorPresupuestoCommand(requestCommand);

        Presupuesto presupuesto;
        try {
            presupuesto = this.creadorPresupuesto.crearPresupuesto(command);

            Response response = 
            new Response(presupuesto.id().valor(),
                        presupuesto.nombre().valor(),
                        presupuesto.valor().valor());

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();        
            return ResponseEntity.created(uri).body(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }        
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

final class Response {
    private String id;
    private String nombre;
    private double valor;

    public Response(String id, String nombre, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }   
}
