package solucion.reto3.reto3.repositorio;


import java.util.List;
import java.util.Optional;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucion.reto3.reto3.crud.MessagesCrudRepositorio;
import solucion.reto3.reto3.modelo.Messages;

/**
 *
 * @author USUARIO
 */
@Repository
public class MessagesRepositorio {
    @Autowired
    private MessagesCrudRepositorio crud3;
    public List<Messages> getAll(){
        return (List<Messages>) crud3.findAll();
    }
    public Optional<Messages> getMessages(int id){
        return crud3.findById(id);
    }

    public Messages save(Messages messages){
        return crud3.save(messages);
    }
    public void delete(Messages messages){
        crud3.delete(messages);
    }

}
