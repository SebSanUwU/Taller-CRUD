package co.edu.escuelaing.edu.CRUD.Taller.CRUD.controller;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.exception.PropertyNotFoundException;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstatePropertyDTO;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.service.RealEstatePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Object> createProperty(@RequestBody RealEstatePropertyDTO property){
        RealEstateProperty realEstateProperty = new RealEstateProperty(property.getAddress(), property.getSize(), property.getPrice(), property.getDescription());
        RealEstateProperty newProperty = propertyService.create(realEstateProperty);
        return new ResponseEntity<>(newProperty, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<RealEstateProperty> updateProperty(@PathVariable String id,@RequestBody RealEstatePropertyDTO propertyDTO){
        RealEstateProperty property = propertyService.findById(id);
        if (property == null){
            throw new PropertyNotFoundException(id);
        }
        RealEstateProperty updateProperty = propertyService.update(property,propertyDTO);
        return ResponseEntity.ok(updateProperty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProperty(@PathVariable String id){
        boolean flag = propertyService.deleteProperty(id);
        return ResponseEntity.ok(flag);
    }
}
