package solucion.reto3.reto3.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solucion.reto3.reto3.modelo.Messages;
import solucion.reto3.reto3.repositorio.MessagesRepositorio;

@Service
public class ServiceMessages {
    @Autowired
    private MessagesRepositorio metodosCrud;

    public List<Messages> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Messages> getMessages(int messagesId) {
        return metodosCrud.getMessages(messagesId);
    }

    public Messages save(Messages messages){
        if(messages.getIdMessage()==null){
            return metodosCrud.save(messages);
        }else{
            Optional<Messages> evt= metodosCrud.getMessages(messages.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(messages);
            }else{
                return messages;
            }
        }
    }
    public Messages update(Messages message){
        if(message.getIdMessage()!=null){
            Optional<Messages> e= metodosCrud.getMessages(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessages(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
