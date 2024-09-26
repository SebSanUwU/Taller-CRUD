package co.edu.escuelaing.edu.CRUD.Taller.CRUD.service;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
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
}
