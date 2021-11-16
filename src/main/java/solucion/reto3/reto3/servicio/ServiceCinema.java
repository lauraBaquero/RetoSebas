package solucion.reto3.reto3.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solucion.reto3.reto3.modelo.Cinema;
import solucion.reto3.reto3.repositorio.CinemaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCinema {
    @Autowired
    private CinemaRepositorio metodosCrud;

    public List<Cinema> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cinema> getCinema(int idCinema){
        return metodosCrud.getCinema(idCinema);
    }

    public Cinema save(Cinema cinema){
        if(cinema.getId()==null){
            return metodosCrud.save(cinema);
        }else{
            Optional<Cinema> evt=metodosCrud.getCinema(cinema.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cinema);
            }else{
                return cinema;
            }
        }
    }
    public Cinema update(Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema> e=metodosCrud.getCinema(cinema.getId());
            if(!e.isEmpty()){
                if(cinema.getName()!=null){
                    e.get().setName(cinema.getName());
                }
                if(cinema.getOwner()!=null){
                    e.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity()!=null){
                    e.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getDescription()!=null){
                    e.get().setDescription(cinema.getDescription());
                }
                if(cinema.getCategory()!=null){
                    e.get().setCategory(cinema.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cinema;
            }
        }else{
            return cinema;
        }
    }


    public boolean deleteCinema(int idCinema) {
        Boolean aBoolean = getCinema(idCinema).map(cinema -> {
            metodosCrud.delete(cinema);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
