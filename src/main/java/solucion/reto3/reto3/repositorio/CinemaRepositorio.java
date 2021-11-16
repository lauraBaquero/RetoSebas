package solucion.reto3.reto3.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucion.reto3.reto3.modelo.Cinema;
import solucion.reto3.reto3.crud.CinemaCrudRepositorio;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepositorio {
    @Autowired
    private CinemaCrudRepositorio crud;


    public List<Cinema> getAll(){
        return (List<Cinema>) crud.findAll();
    }

    public Optional <Cinema> getCinema(int id){
        return crud.findById(id);
    }

    public Cinema save(Cinema cinema){
        return crud.save(cinema);
    }
    public void delete(Cinema cinema){
        crud.delete(cinema);
    }

}