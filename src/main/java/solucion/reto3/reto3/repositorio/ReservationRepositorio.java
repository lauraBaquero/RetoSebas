package solucion.reto3.reto3.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucion.reto3.reto3.crud.ReservationCrudRepositorio;
import solucion.reto3.reto3.modelo.Reservation;

@Repository

public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }
}
