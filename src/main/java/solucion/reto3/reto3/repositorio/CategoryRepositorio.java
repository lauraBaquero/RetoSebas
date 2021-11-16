package solucion.reto3.reto3.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucion.reto3.reto3.crud.CategoryCrudRepositorio;
import solucion.reto3.reto3.modelo.Category;

/**
 *
 * @author USUARIO
 */
@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio crud2;

    public List<Category> getAll(){
        return (List<Category>) crud2. findAll();
    }

    public Optional <Category> getCategory(int id){
        return crud2.findById(id);
    }

    public Category save(Category categoria){
        return crud2.save(categoria);
    }
    public void delete(Category categoria){
        crud2.delete(categoria);
    }
}

