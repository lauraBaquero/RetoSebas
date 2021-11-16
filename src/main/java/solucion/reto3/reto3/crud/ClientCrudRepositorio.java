package solucion.reto3.reto3.crud;

import org.springframework.data.repository.CrudRepository;
import solucion.reto3.reto3.modelo.Client;

public interface ClientCrudRepositorio extends CrudRepository<Client,Integer > {
}