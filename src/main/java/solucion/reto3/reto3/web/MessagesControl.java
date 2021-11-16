package solucion.reto3.reto3.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import solucion.reto3.reto3.modelo.Messages;
import solucion.reto3.reto3.servicio.ServiceMessages;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MessagesControl {
    @Autowired
    private ServiceMessages service;
    @GetMapping("/all")
    public List<Messages> getMessages(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> getMessages(@PathVariable("id") int messagesId) {
        return service.getMessages(messagesId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages messages) {
        return service.save(messages);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages messages) {
        return service.update(messages);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messagesId) {
        return service.deleteMessage(messagesId);
    }
}
