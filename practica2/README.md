# Practica 2

### Descripción
Esta práctica entiende los funcionamientos básicos de como actúa JPA junto a servicios REST para poder crear una API funcional en Spring Boot, la cual se ayuda de Oracle para la obtención y almacenamiento de los datos a consumir.

### Versión 
Actualmente este proyecto está es su versión 0.0.1

### Requerimientos
* Windows 10, Windows 11 o cualquier version de Linux estable
* Java 8 o superior
* Maven
* Docker

### Guía para la instalación
1. Preparar el entorno de desarollo (Tener instalado todos los requerimientos anteriormente mencionados).
2. Abrir una terminal con la ubicación de la carpeta de nuestro proyecto.
![](https://i.imgur.com/db2hYRW.png)
3. Dentro de la terminal corremos el siguiente comando:
    `$ mvn clean install package`
    Esto hará que borren compilaciones anteriores de programa y así posterior a eso será creada la nueva version compilada (archivo .jar).
4. Crear un archivo Dockerfile en la carpeta de nuestro proyecto, este archivo debe contener todo lo necesario para crear una imagen de java 8 en base a nuestro proyecto compilado (archivo .jar). Ejemplo:
    ```
    FROM openjdk:8-jdk-alpine
    VOLUME /tmp
    COPY target/practica2-0.0.1.jar app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]
    ```
5. Construir la imagen de java 8 basada en las configuraciones de nuestro Dockerfile, para ello corremos el siguiente comando en consola:
    `$ docker build -t <image-name> .`
6. Crear y correr un contenedor de docker basada en nuestra imagen recien creada:
    `$ docker run -p <local-port>:<project-port> <image-name>`

Con todos estos pasos se logrará tener un contenedor en docker corriendo con nuestro proyecto.

### Funcionamiento
Luego de tener contenedor corriendo en docker, se pueden hacer peticiones REST desde cualquier aplicación o otro proyecto a los diferentes endpoint contenidos dentro del contenedor. Para esta prueba haremos uso de Postman, con la cual haremos una petición de tipo GET la cual nos trará todos nuestros clientes resguardados en la base de datos.
![](https://i.imgur.com/LWBEhFl.png)

### Tecnologias y librerias usadas
Para la correcta creación de dicho proyecto se hizo uso de las siguiente tecnologías y librerias:
* Spring Web
* Oracle Driver
* Spring Data JPA
* Lombok
* ModelMapper V2.4.4

### Posibles errores
* Error al compilar el proyecto con Maven.
    * **Corrección**: Correr Docker. Este error se da, ya que Maven no puede ejecutar las pruebas unitarias de Spring, dado que usas un host de docker para poder conectase a nuestra máquina local y así enlazar hacia la base de datos.

### Preguntas Frecuentes

### Autor
*Nombre*: José Ottoniel Sincal Guitzol