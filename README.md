# Spring
Anotaciones y desarrollos con spring.

## Documentaciones

1. https://www.baeldung.com/spring-rest-openapi-documentation.
2. https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
3. https://spring.io/tools.

## Crear un proyecto

Para Crear un proyecto basta con ingresar al siguiente enlace https://start.spring.io/.

Y seleccionar los campos deseados tal y como se muestra en las siguientes imagenes:

![Imagen 1](./screenshot/Screenshot_1.png)
![Imagen 2](./screenshot/Screenshot_6.png)

## Configuracion del archivo pom.xml

Se deben agregar las siguientes lineas de codigo dentro de nuestro archivo pom.xml

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

```

## Conectarse a una base de datos en Postgres

1. Inicializar Pg Admin 4 de nuestra computadora.
2. Tener una base de datos creada.
3. Agregar la siguiente instruccion al archivo application.properties.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/Nombre_DB
spring.datasource.password=pacho
spring.datasource.username=postgres
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

## Ingresar a swagger

1. Clic derecho sobre el proyecto > run as > clic en spring boot app.
2. Dirigirse a la ruta http://localhost:8080/swagger-ui.html.