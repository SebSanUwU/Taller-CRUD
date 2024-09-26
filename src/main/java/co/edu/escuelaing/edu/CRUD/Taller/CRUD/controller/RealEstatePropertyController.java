package co.edu.escuelaing.edu.CRUD.Taller.CRUD.controller;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.service.RealEstatePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/property")
public class RealEstatePropertyController {
    @Autowired
    RealEstatePropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<RealEstateProperty>> getAllproperties(){
        List<RealEstateProperty> properties = propertyService.getAllProperty();
        return ResponseEntity.ok(properties);
    }

    @PostMapping
    public ResponseEntity<Object> createProperty(@RequestBody RealEstateProperty property){
        RealEstateProperty realEstateProperty = propertyService.create(property);
        URI createdMessageUri = URI.create("/api/property");
        return ResponseEntity.created(createdMessageUri).body(realEstateProperty);
    }
}
