# Taller-CRUD

Este proyecto consiste en la creación de una arquitectura de software para la consulta de propiedades de bienes raíces.

## Arquitectura

- **Cliente HTML + CSS + JS**: Visualización de las propiedades. A través de peticiones Fetch API, se realizarán las solicitudes al backend.
- **Backend Spring Boot**: Lógica del modelo de datos `RealEstateProperty`.
- **MySQL**: Motor de bases de datos SQL para la persistencia de los datos.

A continuación, se muestra una imagen de la arquitectura propuesta y desplegada en máquinas EC2 de AWS:

**Se utilizaron dos máquinas EC2: una dedicada para el cliente + backend y otra para el servidor MySQL.**

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