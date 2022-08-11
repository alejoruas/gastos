package com.ars.gastos.presupuesto.application.servicio;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ars.gastos.common.service.Service;
import com.ars.gastos.common.service.TrackTransaction;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoCommand;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoRequest;
import com.ars.gastos.presupuesto.application.puerto.in.GetPresupuestoUseCase;
import com.ars.gastos.presupuesto.application.puerto.out.PresupuestoRepository;
import com.ars.gastos.presupuesto.domain.Presupuesto;
import com.ars.gastos.presupuesto.domain.PresupuestoNoEncontrado;

@Service
@Component
public final class GetPresupuesto implements GetPresupuestoUseCase {

    private PresupuestoRepository repository;

    public GetPresupuesto(PresupuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Presupuesto getPresupuesto(GetPresupuestoCommand command) {
        TrackTransaction transaction = new TrackTransaction("SAVE " + command.request().id());
        transaction.beginTransaction();
        Presupuesto presupuesto = null;

        try {
            presupuesto = this.repository.searchById(command.request().id()).orElseGet(() -> {
                throw new PresupuestoNoEncontrado();
            });
        } catch(NoSuchElementException ex) {
            throw new PresupuestoNoEncontrado();
        }       

        transaction.finishTransaction();

        System.out.println(transaction.printInfoTransactionNanos());
        System.out.println(transaction.printInfoTransactionMilis());
        return presupuesto;
    }    
}
