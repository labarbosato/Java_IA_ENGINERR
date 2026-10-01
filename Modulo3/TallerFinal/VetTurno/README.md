# API VetTurno

## Descripción 
VetTurno es una API REST desarrollada para digitalizar la gestión de citas de la Veterinaria Huellitas. Permite administrar propietarios, mascotas, veterinarios y citas, evitando cruces de horario y manteniendo la información persistida en MySQL.

## Historia de Veterinaria Huellitas
Doña Marta abrió Veterinaria Huellitas hace seis años en un barrio donde conoce por su nombre a muchas familias y a sus
mascotas. Ella atiende la clínica con el doctor Andrés y con Paula, quien recibe llamadas, responde mensajes y organiza las citas.
La agenda todavía vive entre un cuaderno y conversaciones de WhatsApp. Cuando el día está ocupado, Paula puede reservar dos
consultas para el mismo veterinario a la misma hora, escribir mal el nombre de una mascota o perder el teléfono de su
responsable. El problema no es falta de cuidado: es que la información está dispersa.

## Tecnologías implementadas
* Java 17
* Spring Boot
* Maven
* Spring Web / REST
* Spring Data JPA
* MYSQL
* Spring Security
* JWT
* BCrypt
* Bean Validation
* Swagger / OpenAPI
* Git / GitHub

## Cómo ejecutar la API

### 1. Requisitos previos
- Java 17
- Maven (o usa el wrapper incluido, no necesitas instalarlo aparte)
- MySQL instalado y corriendo

### 2. Clonar el repositorio desde la terminal
1. `git clone https://github.com/labarbosato/Java_IA_ENGINERR.git` - Clonar el proyecto
2. `cd Java_IA_ENGINERR/Modulo3/TallerFinal/VetTurno` - Ingresar a la ruta principal del proyecto

### 3. Configurar la base de datos
Crea una base de datos vacía en MySQL llamada `vetturno`:
```sql
CREATE DATABASE vetturno;
```
Verifica que las credenciales en `src/main/resources/application.properties` coincidan con tu usuario y contraseña de MySQL.

### 4. Ejecutar la aplicación

**Opción 1: Desde IntelliJ IDEA**
Abre el proyecto, espera a que Maven resuelva las dependencias, y ejecuta la clase principal `VetTurnoApplication.java` desde el icono de play ▶️.

**Opción 2: Desde la terminal - CMD**
Windows:
`.\mvnw.cmd spring-boot:run`
macOS/Linux:
`./mvnw spring-boot:run`

### 5. Acceder a la API
http://localhost:8080