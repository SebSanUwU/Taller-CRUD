package co.edu.escuelaing.edu.CRUD.Taller.CRUD.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PropertyNotFoundException extends ResponseStatusException {
    public PropertyNotFoundException(String id){
        super(HttpStatus.NOT_FOUND,"Property with ID: " + id +" not found");
    }
}
