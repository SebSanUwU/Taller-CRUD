# Taller-CRUD

Este proyecto consiste en la creación de una arquitectura de software para la consulta de propiedades de bienes raíces.

## Arquitectura

- **Cliente HTML + CSS + JS**: Visualización de las propiedades. A través de peticiones Fetch API, se realizarán las solicitudes al backend.
- **Backend Spring Boot**: Lógica del modelo de datos `RealEstateProperty`.
- **MySQL**: Motor de bases de datos SQL para la persistencia de los datos.

A continuación, se muestra una imagen de la arquitectura propuesta y desplegada en máquinas EC2 de AWS:

![image](https://github.com/user-attachments/assets/6619c92d-85c7-4d3d-bb04-e1f5f29ccee6)


**Se utilizaron dos máquinas EC2: una dedicada para el cliente + backend y otra para el servidor MySQL.**

## Implementación del patrón MVC (Modelo-Vista-Controlador)

Este proyecto sigue el patrón de diseño MVC, que separa la lógica de negocio, la interfaz de usuario y el control de flujo, facilitando el mantenimiento y la escalabilidad. A continuación se describe cómo cada componente del proyecto está estructurado dentro de este patrón:

### 1. **Modelo**
   El modelo se encarga de la lógica de negocio relacionada con las propiedades inmobiliarias y su interacción con la base de datos.
   - **`RealEstateProperty`**: Representa una entidad de propiedad inmobiliaria en la base de datos.
   - **`RealEstatePropertyRepository`**: Es el repositorio que extiende `JpaRepository` para realizar operaciones CRUD con la base de datos MySQL.

### 2. **Vista**
   La vista corresponde al **Cliente HTML**. Aquí es donde se presenta la información al usuario. La interfaz de usuario es manejada mediante HTML, CSS y JavaScript.
   - Las peticiones del cliente se realizan a través de la **Fetch API** que se comunica con el backend mediante peticiones HTTP a los endpoints del controlador.

### 3. **Controlador**
   Los controladores manejan las solicitudes del cliente y coordinan las respuestas adecuadas del servidor. 
   - **`RealEstatePropertyController.java`**: Es el controlador REST que maneja las solicitudes HTTP (`GET`, `POST`, `PUT`, `DELETE`) para la entidad `RealEstateProperty`. Define los endpoints para la gestión de propiedades inmobiliarias.
   - **`HomeController.java`**: Controla las solicitudes básicas del servidor y redirige a la vista principal si es necesario.

### Flujo del patrón MVC en el proyecto:

1. **Cliente HTML** realiza una solicitud HTTP (por ejemplo, para consultar propiedades o crear una nueva) utilizando la Fetch API.
2. **Backend**:
   - El controlador recibe la solicitud y la procesa. Si se necesita interacción con la base de datos, el controlador delega la lógica de negocio al **servicio** correspondiente.
   - El servicio, a su vez, interactúa con el **repositorio** para realizar consultas o modificaciones en la base de datos.
3. **MySQL Server** almacena y gestiona los datos persistentes (propiedades inmobiliarias), y devuelve los resultados de las consultas o confirmaciones de operaciones.
4. **Respuesta**: El controlador recibe la respuesta del servicio y la envía de vuelta al cliente, quien la renderiza en la vista.

Este enfoque asegura una separación clara de responsabilidades, facilitando el mantenimiento y la evolución del proyecto.


## Iniciar el proyecto

Estas instrucciones te ayudarán a obtener una copia del proyecto en funcionamiento en tu máquina local para fines de desarrollo.

### Prerrequisitos

#### Para desarrollo:

- **MySQL Server**: Para la persistencia de datos.
- **Java JDK 8**: Requerido para compilar y ejecutar el código Java.
- **Maven 3.6.0**: Utilizado para la gestión de dependencias y la automatización del proceso de construcción.
- **Un IDE**: Recomendamos IntelliJ IDEA, Eclipse, o cualquier otro IDE que soporte proyectos Java y Maven.
- **Git 2.25.0** (opcional): Para clonar y gestionar el repositorio del proyecto.

### Instalación

Pasos para poner en marcha la arquitectura:

1. **Clonar el repositorio** desde GitHub:
   ```
   git clone https://github.com/SebSanUwU/Taller-CRUD
   ```

2. **Navegar al directorio del proyecto**:
   ```
   cd Taller-CRUD
   ```

3. **Instalar el proyecto con Maven**:
   ```
   mvn clean install
   ```

4. **Ejecución del main**:
   ```
   java -cp target/classes co.edu.escuelaing.edu.CRUD.Taller.CRUD.TallerCrudApplication
   ```

5. **Cliente**: Estará listo para recibir peticiones en `http://localhost:8080/properties`.

### Ejecución del proyecto en la nube (AWS)

Para desplegar el proyecto en AWS, puedes seguir el siguiente enlace con instrucciones de despliegue. Recuerda tener Java y MySQL Server instalados en las máquinas EC2:

[Instrucciones de despliegue en AWS](https://drive.google.com/file/d/1QboCRRbEAiM6T7AZeZpgXgg1j3LV1OoL/view?usp=drive_link)

### Prueba integral de CRUD en AWS

Puedes ver las pruebas integrales del proyecto en el siguiente enlace:

[Pruebas integrales en AWS](https://drive.google.com/file/d/1GaHqbErCJW0MuOcgBHrRh3JTQgEaLxsv/view?usp=drive_link)

## Ejecutar las pruebas

Para ejecutar las pruebas automatizadas del proyecto:

1. Asegúrate de que el proyecto no esté en ejecución.
2. Ejecuta los tests con el siguiente comando:
   ```
   mvn test
   ```

## Descripción de cada test

- **`testSaveNewProperty`**: Verifica la creación de una nueva propiedad mediante una solicitud `POST` y espera un estado `200 OK`.

- **`testUpdateExistingProperty`**: Comprueba la actualización de una propiedad existente con una solicitud `PUT` y espera un estado `200 OK`.

- **`testDeleteExistingProperty`**: Valida la eliminación de una propiedad con una solicitud `DELETE` y espera un estado `200 OK`.

## Construido con

* [Java](https://www.java.com) - Lenguaje de programación
* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework para el desarrollo de aplicaciones Java
* [AWS EC2](https://aws.amazon.com/ec2/) - Servicio en la nube donde se desplegó la aplicación
* [Git](https://git-scm.com/) - Sistema de control de versiones

## Autor

* **Juan Sebastian Camargo Sanchez** - *AREP* - [SebSanUwU](https://github.com/SebSanUwU)
