# Arquitectura DDD

La arquitectura Diseño guiado por el dominio **(Domain Driven Design)** es un conjunto de patrones principos y práticas que nos ayudan a resolver y entender los problemas del negocio **(Dominio)** en el diseño de sistemas orientados a objetos.  

![Imagen 7](./screenshot/Screenshot_7.png)

# Spring Framework

Spring, ofrece como elemento clave el soporte de infraestructura a nivel de aplicación, brindando un completo modelo tanto para la configuración como para la programación de aplicaciones empresariales desarrolladas bajo Java, sin discriminación en cuanto al despliegue de la plataforma.

Todo esto trae consigo una gran ventaja, ya que permite que los equipos de desarrollo puedan enfocarse directamente en la lógica empresarial que requiere la aplicación, haciendo el proceso más corto, rápido y eficaz, ahorrando líneas de código evitando tareas repetitivas. 

# Contenido

1. [Documentaciones Y Lecturas Sugeridas](#documentaciones-y-lecturas-sugeridas)
2. [Glosario de terminos](#glosario-de-terminos)
3. [Crear un proyecto](#crear-un-proyecto)
4. [Estructura de los proyectos](#estructura-de-los-proyectos)
5. [Esquema de construccion](#esquema-de-construccion)
6. [Describiendo archivos](#describiendo-archivos)

## [Documentaciones Y Lecturas Sugeridas](#contenido)

1. https://www.baeldung.com/spring-rest-openapi-documentation
2. https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
3. https://www.baeldung.com/spring-boot-testing
4. https://spring.io/tools

## [Glosario de terminos](#contenido)

- DTO:
- MAPPER:
- REST:
- DOM:
- POM:
- Value Object:

## [Crear un proyecto](#contenido)

### Primeros pasos

Con Spring Initializr se pueden generar y configurar proyectos de forma segura y rapida aprovechando las distintas configuraciones y opciones que nos ofrece la plataforma.

Para Crear un proyecto basta con ingresar al siguiente enlace https://start.spring.io/ para asi seleccionar los campos deseados tal y como se explicara a continuacion:

**Paso 1:** Opciones para la creacion del proyecto

Dependiendo de las necesidades de nuestro proyecto podemos seleccionar entre **Maven** o **Gradel** que son herramientas de software libre para gestionar proyectos Java.

Del mismo modo se nos brindan 3 opciones para el lenguaje de programacion que estara presente en todo nuestro los cuales son: Java, Kotlin y Groovy.

Finalmente, se debe seleccionar la version de Spring Boot a utilizar, para est se recomienda utilizar la version estable, la cual se ve seleccionada por defecto. 

![Imagen 1](./screenshot/Screenshot_1.png)

**Paso 2:** Metadatos del proyecto

En este paso se debe escribir el grupo donde iran los archivos, el artifact que corresponde al nombre del proyecto.

A continuacion, dentro de opciones escribir la informacion referente al nombre y descripcion del proyecto, junto con el nombre del paquete que sera generado. Para finalmente seleccionar el tipo de empaquetado donde se comprimira el proyecto y version del lenguaje seleccionado previamente. 

![Imagen 2](./screenshot/Screenshot_2.png)

**Paso 3:** Dependencias

Las dependencias hacen parte esencial sde cada proyecto y pueden variar dependiendo de las necesidades de cada uno, pero las dependencias estandar que no pueden faltar son las que se muestran en la siguiente imagen.

![Imagen 3](./screenshot/Screenshot_3.jpeg)

- **SQL Driver o NoSQL Driver:** Puede seleccionarse entre los 2 motores de bases de datos relacionales MySQL y PosgresSQL o en su lugar MongoDB que permiten que los programas se conecten a una base de datos.  
- **Spring Data JPA:** Persista los datos en los almacenes de SQL con Java Persistence API usando Spring Data e Hibernate.
- **Spring Boot DevTools:** Proporciona reinicios rápidos de aplicaciones, LiveReload y configuraciones para una experiencia de desarrollo mejorada.
- **Spring Web:** Cree aplicaciones web, incluidas RESTful, con Spring MVC. Utiliza Apache Tomcat como el contenedor integrado predeterminado.
- **Lombok:** Biblioteca de anotaciones Java que ayuda a reducir el código repetitivo.

**Paso 4:** Generar proyecto

A continuacion, se debe hacer click en el boton **Generate** para obtener el archivo comprimido con nuestro proyecto ya preparado para ser montado en el IDE de nuestra preferencia, aunque se recomienda usar eclipse para estos casos.

**(Opcional) Paso 5:** Adicionar Estructura trabajada en ZABUD

Para mayor comodidad al momento de trabajar nuevos proyectos pude descargar el siguiente archivo: [Estructura](./Estructure.zip).

Al finalizar la descarga, extraiga el archivo y copie el contenido dentro de la carpeta que coniene el archivo principal de su proyecto.

**Paso 6:** Importar proyecto al IDE

Si se usa eclipse basta con importar el proyecto si es maven o importar archivo de forma general.

Para activar Spring Boot en eclipse IDE se necesita descargar la extension Spring Boot Tools 4 del market place el cual se puede acceder desde el menu help.

![Imagen 6](./screenshot/Screenshot_6.png)

**Paso 7:** Activar Swagger 2

Se deben agregar las siguientes lineas de codigo dentro de nuestro archivo `pom.xml` que se encuentra en la raiz del proyecto dentro de las etiquetas `<dependencies></dependencies>`.

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

**Paso 8:** Lombok

Descargar el paquete Lombok en el siguiente enlace https://projectlombok.org/download.

Abrir el archivo ejecutable y seleccionar el IDE utilizado, finalmente hacer clic en el boton **Install / Update**.

![Imagen 4](./screenshot/Screenshot_4.png)

Para finalizar simplemente hacer clic en cerrar o salir de la aplicacion.

![Imagen 5](./screenshot/Screenshot_5.png)

**Paso 9:** Conectarse a una base de datos en Postgres

1. Inicializar Pg Admin 4 de nuestra computadora.
2. Tener una base de datos creada.
3. Agregar la siguiente instruccion al archivo `application.properties`.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/Nombre_DB
spring.datasource.password=root
spring.datasource.username=postgres
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

**Paso 10:** Ingresar a Swagger

1. Clic derecho sobre el proyecto > run as > clic en spring boot app.
2. Dirigirse a la ruta http://localhost:8080/swagger-ui.html.

## [Estructura de los proyectos](#contenido)

Se proponen seis capas conceptuales las cuales son:

### 1. Application

Responsable de coordinar todos los elementos de la aplicación. No contiene lógica de negocio ni mantiene el estado de los objetos de negocio. Es responsable de mantener el estado de la aplicación y del flujo de esta.

### 2. Controller

Tiene clases con el objetivo principal de conectar el backend con las solicitudes que se hagan desde afuera de la aplicación(sistemas web, unirest, entre otros).

### 3. Domain

Contiene la información sobre el Dominio. Es el núcleo de la parte de la aplicación que contiene las reglas de negocio. Es responsable de mantener el estado de los objetos de negocio. (La persistencia de estos objetos se delega en la capa de infraestructura.

### 4. Exceptions

En esta capa se detallan los mensajes de errores personalizados para evitar multiples lineas de advertencias para cada uno de los errores que puedan presentarse al momento de realizar una peticion o consulta a nuestra aplicacion.

### 5. Infraestructure

Esta capa es la capa de soporte para el resto de capas. Provee la comunicación entre las otras capas, implementa la persistencia de los objetos de negocio y las librerías de soporte para las otras capas (Interface, Comunicación, Almacenamiento, etc..)

Dado que son capas conceptuales, su implementación puede ser muy variada y en una misma aplicación, tendremos partes o componentes que formen parte de cada una de estas capas. Por ejemplo, en una aplicación web desarrollada con Laravel, Las vistas formarían parte de la capa de Interface, pero Sass o Less, por ejemplo, serían parte de la infraestructura. Algunos componentes del Framework formarían parte de la infraestructura (Eloquent, Caches, etc...) y otros componentes formarían parte de la aplicación (Controladores, Comandos, Eventos, etc..). Los modelos, por ejemplo, formarían parte de la capa de Dominio.

### 6. Shared

En esta capa se brinda el soporte y control de las excepciones generadas durante la ejecucion de un evento, permitendo la captura de errores y lanzamiento de los mensajes personalizados dentro de la capa de Exceptions.

Tambien se encarga de realizar el proceso de transformacion de la infraestructura, donde las entidades del dominio se convierten de REST, DTO o viceversa.

## [Esquema de construccion](#contenido)

Las capas anteriormente descritas son representadas de la siguiente forma, dentro de los proyectos con sus respectivas subcarpetas.

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

En el siguiente esquema se presenta una sugerencia secuencial al momento de construir y codificar la arquitectura de cada proyecto, con el fin de estandarizar un modelo de trabajo y de este modo, facilitar la importacion de metodos de una dependencia a otra.

```
└── src
    └── main
       └── com
           └── api
               └── Main.java 
               |
               infraestructure
               └── dto
                   └── BaseEntity.java
                       [Name]Dto.java
               └── rest
               |   └── [Name]Rest.java     
               |   
               exceptions
               └── [Name]Exception.java
               |   ErrorCode.java
               |   HandlerException.java
               |   
               shared
               └── domain 
                   [Name].java
               └── infraestructure   
               |   └── mapper  
               |       └── MapperDto.java
               |           MapperRest.java  
               |      
               domain
               └── model 
                   [Name].java
               └── service 
                   [Name]Service.java    
               |   
               infraestructure
               └── mapper
                   └── [Name]Mapper.java
               └── repository
               |   └── database
               |       └── [Name]Repository.java 
               |   └── adapter
               |       └── [Name]Adapter.java 
               |
               application
               └── [Name]Application.java  
               |
               controller
               └── [Name]Controller.java                              
```

## [Describiendo archivos](#contenido)

### Main.java

En el archivo main.java del paquete api simplemente se inicializan Swagger 2 y Jpa Auditing en nuestro proyecto, tal como se muestra a continuacion en el codigo de ejemplo.

```
package com.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
public class SubjectTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectTestApplication.class, args);
	}

}
```

### BaseEntity.java

Este archivo se encuentra en el paquete infraestructure dentro de la carpeta dto y contiene las entidades bases que seran heredadas por las demas entidades que creemos dentro de nuestro proyecto.

```
package com.app.api.infrastructure.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	@CreatedDate
	Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	@LastModifiedDate
	Date fechaActualizada;

}
```

### [Name]Dto.java

Contiene las entidades que seran utilizadas dentro de los campos de la tabla que sera creada dentro de nuestra base de datos.

```
package com.app.api.infrastructure.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class SubjectDto extends BaseEntity {

	private String code;
	private String name;
	private Integer credit;
	
}
```

### [Name]Rest.java

En este archivo se declaran las variables y los tipos de datos que seran utilizados dentro del programa.

```
package com.app.api.infrastructure.rest;

import lombok.Data;

@Data
public class SubjectRest {
	
	private String id;
	private String code;
	private String name;
	private Integer credit;
	
}
```

### [Name]Exception.java

Aqui se heredan los diferentes tipos de errores existentes para luego imprimir un mensaje agradable para el usuario el cual sera mucho mas legible y simple de entender.

```
package com.app.api.exceptions;

public class CodeException extends RuntimeException {

	public CodeException() {
		super("ERROR: Code Exception");
	}
	
}
```

### ErrorCode.java

Aqui se configuran los codigos y mensajes que seran enviados.

```
package com.app.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
	
	private String code;
	private String message;
	
}
```

### HandlerException.java

Aqui se capturan las excepciones y se disparan los metodos encontrados en errorCode.

```
package com.app.api.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class HandlerException {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode generalException(Exception e) {

		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(CodeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode codeException(CodeException e) {

		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(NameException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode nameException(NameException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(IdException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode idException(IdException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(CreditException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode creditException(CreditException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	public String generateId() {
		return UUID.randomUUID().toString();
	}

	public void generateLog(Exception e, ErrorCode ec) {

		log.severe(e.getMessage());
		log.severe(ec.getMessage());
		log.severe(ec.getCode());
		
	}
	
}
```