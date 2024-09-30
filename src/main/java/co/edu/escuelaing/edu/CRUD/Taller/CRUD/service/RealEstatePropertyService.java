package co.edu.escuelaing.edu.CRUD.Taller.CRUD.service;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstatePropertyDTO;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.repository.RealEstatePropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstatePropertyService {
    private final RealEstatePropertyRepository repository;
    @Autowired
    public RealEstatePropertyService(RealEstatePropertyRepository repository){
        this.repository = repository;
    }

    public List<RealEstateProperty> getAllProperty(){
        return (List<RealEstateProperty>) repository.findAll();
    }

    public RealEstateProperty create(RealEstateProperty property) {
        return repository.save(property);
    }

    public RealEstateProperty findById(String id){
        return repository.findById(Long.parseLong(id));
    }

    public RealEstateProperty update(RealEstateProperty property, RealEstatePropertyDTO propertyDTO){
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());
        property.setPrice(propertyDTO.getPrice());
        property.setSize(propertyDTO.getSize());
        return repository.save(property);
    }

    public boolean deleteProperty(String id){
        RealEstateProperty property = findById(id);
        if (property == null){
            return false;
        }
        repository.delete(property);
        return true;
    }
}
