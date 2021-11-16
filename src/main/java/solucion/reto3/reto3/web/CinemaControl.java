package solucion.reto3.reto3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import solucion.reto3.reto3.modelo.Cinema;
import solucion.reto3.reto3.servicio.ServiceCinema;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Cinema")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CinemaControl {
    @Autowired

    private ServiceCinema cinemaService;
    @GetMapping("/all")
    public List<Cinema> getCinemas(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id")int id){
        return  cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema p){
        return cinemaService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema cinema) {
        return cinemaService.update(cinema);}


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idCinema) {
        return cinemaService.deleteCinema(idCinema);
    }
}
