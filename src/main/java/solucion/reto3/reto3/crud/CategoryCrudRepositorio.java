package solucion.reto3.reto3.crud;

import org.springframework.data.repository.CrudRepository;
import solucion.reto3.reto3.modelo.Category;


public interface CategoryCrudRepositorio extends CrudRepository<Category,Integer> {
}