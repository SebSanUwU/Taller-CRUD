package co.edu.escuelaing.edu.CRUD.Taller.CRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RealEstateProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long propertyId;
    private String address;
    private Double price;
    private Double size;
    private String description;

    protected RealEstateProperty(){}

    public RealEstateProperty(String address, Double price, Double size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RealEstateProperty{" +
                "propertyId=" + propertyId +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                '}';
    }
}
