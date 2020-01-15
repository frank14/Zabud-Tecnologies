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
## Lombok

Descargar el paquete Lombok en el siguiente enlace https://projectlombok.org/download

## Agregando Enlaces

- En la clase com.app.api

```
@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
```

- En la clase com.app.api.application

```

```

- En la clase com.app.api.controller

```
@RestController
@RequestMapping("/subject")
```

- En la clase com.app.api.domain.model

```
@Getter
@AllArgsConstructor
```

- En la clase com.app.api.domain.service

```

```

- En la clase com.app.api.exceptions

    1. ErrorCode.java

        ```
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        ```

    2. 

        ```
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        ```

- En la clase com.app.api.infrastructure.dto

1. Base Entity

    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    ```

2. SubjectDto

    ```
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "subjects")
    ```

- En la clase com.app.api.infrastructure.mapper

```
@Component
```

- En la clase com.app.api.infrastructure.repository.adapter

```

```

- En la clase com.app.api.infrastructure.repository.database

```
@Repository
```

- En la clase com.app.api.infrastructure.rest

```
@Data
```

- En la clase com.app.api.shared.domain

```
@Getter
try catch
```

- En la clase com.app.api.shared.infrastructure.mapper

```
<I O>
<O I>
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

## Estructura de los proyectos

```
com.app.api
com.app.api.application
com.app.api.controller
com.app.api.domain.model
com.app.api.domain.service
com.app.api.exceptions
com.app.api.infrastructure.dto
com.app.api.infrastructure.mapper
com.app.api.infrastructure.repository.adapter
com.app.api.infrastructure.repository.database
com.app.api.infrastructure.rest
com.app.api.shared.domain
com.app.api.shared.infrastructure.mapper
```

![Imagen 3](./screenshot/Screenshot_2.png)
