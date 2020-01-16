# Backend

Instalar las dependencias

`yarn install`

Actualizar las dependencias

`yarn update`

Iniciar el proyecto

`yarn dev`

## Consultas a la api por postman o insomnia

### Usuarios

- Obtener la lista de todos los usuarios

GET: `http://localhost:4000/api/users`

- Registrar un usuario

POST: `http://localhost:4000/api/users`

Formato JSON

```
{
	"email": "correo",
	"first_name": "nombre",
	"last_name": "apellido",
	"avatar": "imagen"
}
```

- Obtener un usurio

GET: `http://localhost:4000/api/users/id`

- Actualizar un usuario

PUT: `http://localhost:4000/api/users/id`


- Borrar un usuario

DELETE: `http://localhost:4000/api/users/id`