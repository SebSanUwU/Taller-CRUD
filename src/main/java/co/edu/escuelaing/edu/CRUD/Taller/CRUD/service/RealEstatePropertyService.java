package co.edu.escuelaing.edu.CRUD.Taller.CRUD.service;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstatePropertyDTO;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.repository.RealEstatePropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de propiedades inmobiliarias.
 * Esta clase se encarga de las operaciones relacionadas con las propiedades, incluyendo la creación,
 * recuperación, actualización y eliminación de propiedades en el repositorio.
 */
@Service
public class RealEstatePropertyService {

    private final RealEstatePropertyRepository repository;

    /**
     * Constructor del servicio de propiedades inmobiliarias.
     *
     * @param repository el repositorio de propiedades que se inyecta mediante Spring
     */
    @Autowired
    public RealEstatePropertyService(RealEstatePropertyRepository repository) {
        this.repository = repository;
    }

    /**
     * Recupera todas las propiedades inmobiliarias.
     *
     * @return una lista de todas las propiedades
     */
    public List<RealEstateProperty> getAllProperty() {
        return (List<RealEstateProperty>) repository.findAll();
    }

    /**
     * Crea una nueva propiedad inmobiliaria y la guarda en el repositorio.
     *
     * @param property la propiedad a crear
     * @return la propiedad creada
     */
    public RealEstateProperty create(RealEstateProperty property) {
        return repository.save(property);
    }

    /**
     * Busca una propiedad por su identificador único.
     *
     * @param id el identificador de la propiedad a buscar
     * @return la propiedad encontrada, o null si no se encuentra
     */
    public RealEstateProperty findById(String id) {
        return repository.findById(Long.parseLong(id));
    }

    /**
     * Actualiza una propiedad existente con la información de un DTO.
     *
     * @param property   la propiedad existente a actualizar
     * @param propertyDTO el DTO que contiene la nueva información de la propiedad
     * @return la propiedad actualizada
     */
    public RealEstateProperty update(RealEstateProperty property, RealEstatePropertyDTO propertyDTO) {
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());
        property.setPrice(propertyDTO.getPrice());
        property.setSize(propertyDTO.getSize());
        return repository.save(property);
    }

    /**
     * Elimina una propiedad por su identificador único.
     *
     * @param id el identificador de la propiedad a eliminar
     * @return true si la propiedad fue eliminada, false si no se encontró
     */
    public boolean deleteProperty(String id) {
        RealEstateProperty property = findById(id);
        if (property == null) {
            return false;
        }
        repository.delete(property);
        return true;
    }
}

