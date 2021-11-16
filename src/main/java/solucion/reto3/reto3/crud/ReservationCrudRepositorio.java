package solucion.reto3.reto3.crud;

import solucion.reto3.reto3.modelo.Reservation;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepositorio extends CrudRepository<Reservation,Integer>{
    @Query("SELECT e.client, COUNT(e.client)FROM Reservation AS e group by e.client order by COUNT(e.client)DESC")

    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus(String status);


}
