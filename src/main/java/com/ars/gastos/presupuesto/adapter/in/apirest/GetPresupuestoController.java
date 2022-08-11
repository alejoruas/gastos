package com.ars.gastos.presupuesto.adapter.in.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoRequest;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoUseCase;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoNoEncontrado;

@RestController
public final class GetPresupuestoController {
    private final GetPresupuestoUseCase finderPresupuesto;

    public GetPresupuestoController(GetPresupuestoUseCase finderPresupuesto) {
        this.finderPresupuesto = finderPresupuesto;
    }

    @GetMapping("/presupuesto/{id}")
    public ResponseEntity getPresupuesto(@PathVariable String id){
        GetPresupuestoRequest requestCommand 
            = new GetPresupuestoRequest(id);
        GetPresupuestoCommand command = new GetPresupuestoCommand(requestCommand);

        Presupuesto presupuesto;
        try {
            presupuesto = this.finderPresupuesto.getPresupuesto(command);
            Response response = 
            new Response(presupuesto.id().valor(),
                        presupuesto.nombre().valor(),
                        presupuesto.valor().valor());

                
            return ResponseEntity.ok(response);
        } catch (PresupuestoNoEncontrado ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }  

    }
}