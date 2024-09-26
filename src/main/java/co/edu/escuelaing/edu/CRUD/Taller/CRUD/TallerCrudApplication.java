package co.edu.escuelaing.edu.CRUD.Taller.CRUD;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.repository.RealEstatePropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerCrudApplication {
	private static final Logger log = LoggerFactory.getLogger(TallerCrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TallerCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RealEstatePropertyRepository repository){
		return (args) -> {
			// save a few Real Estate Property
			repository.save(new RealEstateProperty("Calle 93 #20-58",1200000d,120d,"Hermoso apartamento en arriendo"));

			// fetch all Real Estate Property
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			RealEstateProperty realEstateProperty= repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(realEstateProperty.toString());
			log.info("");
		};

	};

}
