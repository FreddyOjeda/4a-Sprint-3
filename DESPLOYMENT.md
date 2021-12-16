## Despliegue de la aplicacion

1. Compilar la aplicacion `.\mvnw package`
2. `Heroku login`
3. `heroku create`
4. `heroku container:login`
5. `heroku container:push web -a compras-ms`
6. `heroku container:release web`