package co.edu.escuelaing.edu.CRUD.Taller.CRUD.repository;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealEstatePropertyRepository extends CrudRepository<RealEstateProperty,Long> {
    RealEstateProperty findById(long id);
}
