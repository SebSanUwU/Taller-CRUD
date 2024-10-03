package co.edu.escuelaing.edu.CRUD.Taller.CRUD;

import co.edu.escuelaing.edu.CRUD.Taller.CRUD.controller.RealEstatePropertyController;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstateProperty;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.model.RealEstatePropertyDTO;
import co.edu.escuelaing.edu.CRUD.Taller.CRUD.service.RealEstatePropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class TallerCrudApplicationTests {

	final String BASE_URL = "http://localhost:8080/api/property";

	@MockBean
	private RealEstatePropertyService propertyService;

	@Autowired
	private RealEstatePropertyController realEstatePropertyController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = standaloneSetup(realEstatePropertyController).build();
	}

	@Test
	public void testSaveNewProperty() throws Exception {
		RealEstateProperty property = new RealEstateProperty("Calle 93 EXAMPLE", 10d, 10d, "EXAMPLE");
		when(propertyService.create(any())).thenReturn(property);

		// Corrijo el JSON de la propiedad enviada para que coincida con la entidad
		String json = "{\"address\":\"Calle 93 EXAMPLE\",\"price\":10,\"size\":10,\"description\":\"EXAMPLE\"}";

		mockMvc.perform(post(BASE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk());

		verify(propertyService, times(1)).create(any());
	}

	@Test
	public void testUpdateExistingProperty() throws Exception {
		// Simula una propiedad existente que será actualizada
		RealEstateProperty existingProperty = new RealEstateProperty("Calle 93 ORIGINAL", 1200000d, 100d, "Original description");

		// Simula la propiedad actualizada
		RealEstateProperty updatedProperty = new RealEstateProperty("Calle 93 UPDATED", 1500000d, 130d, "Updated description");

		// El JSON que vamos a enviar en la petición PUT
		String json = "{\"address\":\"Calle 93 UPDATED\",\"price\":1500000,\"size\":130,\"description\":\"Updated description\"}";

		// Mockear el comportamiento del servicio para que devuelva la propiedad existente
		when(propertyService.findById("2")).thenReturn(existingProperty);

		// Mockear el comportamiento del servicio para que devuelva la propiedad actualizada al hacer el update
		when(propertyService.update(any(RealEstateProperty.class), any(RealEstatePropertyDTO.class))).thenReturn(updatedProperty);

		// Ejecutar el test de actualización
		mockMvc.perform(put(BASE_URL + "/2")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk());

		// Verificar que el método update fue llamado exactamente una vez
		verify(propertyService, times(1)).update(any(RealEstateProperty.class), any(RealEstatePropertyDTO.class));
	}




	@Test
	public void testDeleteExistingProperty() throws Exception {
		RealEstateProperty property = new RealEstateProperty("Calle 93 EXAMPLE", 10d, 10d, "EXAMPLE");
		when(propertyService.findById("2")).thenReturn(property);

		mockMvc.perform(delete(BASE_URL + "/2")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		verify(propertyService, times(1)).deleteProperty("2");
	}
}

