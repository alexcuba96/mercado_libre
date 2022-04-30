# Examen Mercadolibre
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.

- boolean isMutant(String[] adn); En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

![image](https://user-images.githubusercontent.com/59976584/166118297-ca26cf3a-2035-4d09-ba74-cb680382c341.png)

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.

# Ejemplo (Caso mutante)
- String[] adn = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
En este caso el llamado a la función isMutant(adn) devuelve “true”.
Desarrolla el algoritmo de la manera más eficiente posible

# Desafíos
## Nivel 1
- Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto

## Nivel 2
- Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
POST → /mutant/
{
“adn”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden

## Nivel 3
- Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1
millón de peticiones por segundo).
Test-Automáticos, Code coverage > 80%.



# Arquitectura
![image](https://user-images.githubusercontent.com/59976584/166125204-dd85ddbc-cb9b-4693-9c08-df9d43839231.png)

# Requerimientos
- Java 11
- Spring Boot 2
- Gradle
- CURL
- JQ
- IDE STS 4

# Tecnologias
- Spring boot
- Spring cloud
- Spring clous security
- Eureka
- Lombok
- Spring Boot - Bootstrapping
- Gradle
- 

# Pasos para la instalación del proyecto
- Git clone al proyecto
- Abrir STS e importar todos los proyectos requeridos(config-service,examen,gateway-service,registry-service)
- Entrar a la configuración del servidor de config-service y agregar las variables de entorno su usuario y password de GIT para acceder a los archivos config-data de las otras aplicaciones
![image](https://user-images.githubusercontent.com/59976584/166119023-5110ae2c-04d8-40c6-846b-c0a4e629808e.png)

- Ejecutar los programas
###### config-service
###### registry-service
###### examen
###### gateway-service
![image](https://user-images.githubusercontent.com/59976584/166119274-25f87c8c-36f3-4ba3-97df-51a0e9bb387f.png)

### Una vez subida todas las aplicaciones vamos a eureka server para validar que esten los microservicios arriba
![image](https://user-images.githubusercontent.com/59976584/166119305-2047f94d-d82d-48f4-9a80-a158fbd74f10.png)

 

# Services Gateway
### Mutant localhost:8080/mutant/
Metodo Post
Content-Type: application/json

Request Mutante Permitido

{
    "adn": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
Response Status: 200 OK

Request Humano Permitido

{
    "adn": [
        "TTGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCTCTA",
        "TCACTG"
    ]
}
Response Status: 403 Forbidden

Request Rechazado

{
    "adn": [
        "TTHCGA",
        "CAG1GC",
        "TTAGT",
        "AGAAGG",
        "CCTCTA",
        "TCACTG"
    ]
}
Response Status: 400 Bad Request

Request Rechazado (Error Json)

{
    "adna": [
        "TTHCGA",
        "CAG1GC",
        "TTAGT",
        "AGAAGG",
        "CCTCTA",
        "TCACTG"
    ]
}
Response Status: 400 Bad Request

### localhost:8080/stats/
Metodo GET 

devuelva un Json con las estadísticas de las
verificaciones de ADN
### Ejemplo Response
- {“count_mutant_
”:40, “count_human_dna”:100: “ratio”:0.4}

