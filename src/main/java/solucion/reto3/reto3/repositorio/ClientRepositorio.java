package solucion.reto3.reto3.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucion.reto3.reto3.crud.ClientCrudRepositorio;
import solucion.reto3.reto3.modelo.Client;

/**
 *
 * @author USUARIO
 */
@Repository
public class ClientRepositorio {
    @Autowired
    private ClientCrudRepositorio crud1;


    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }

    public Optional <Client> getClient(int id){
        return crud1.findById(id);
    }

    public Client save(Client client){
        return crud1.save(client);
    }
    public void delete(Client client){
        crud1.delete(client);
    }
}

