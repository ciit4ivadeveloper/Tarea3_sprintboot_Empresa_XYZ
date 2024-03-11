=== Proyecto que ejecuta los llamados esta realizado en SprintBoot

    1. Para compilar el proyecto: mvn clean package -DskipTests
    2. Para ejecutar el proyecto: java -jar target\spring-camel-integration-1.0.0-SNAPSHOT.jar

    Prerrequisitos:

    1. Que este levantado el servicio del aplicativo en Python
    2. Que este levantado el servicio del aplicativo en .Net


    Ejecutar pruebas al servicio:
    Metodo POST:

    http://localhost:8080/realizaCompra

    Body:

     {
        "codigo": 1,
        "identificacion": "0123123123",
        "nombres": "ahskdsadhsakd",
        "apellidos": "campeon",
        "telefono": "0984612323",
        "direccion": "dia",
        "perfilCompra": 1,  
        "valorCompra": 9092.09
    }

    NOTA: perfilCompra identifica que tipo de empresa se va a realizar la compra
        1 Es la empresa ABC con sus servicios en .Net se puede verificar  
          Metodo GET: http://localhost:5045/persona
        2 Es la empresa 123 con sus servicios en Python se puede verificar 
          Metodo GET: http://localhost:5000/persona

    Se adjunta collection de Postman para probar los servicios con solo importar la coleccion.

=== Referencias:
    Elaborado por Cristian Idrovo
    Maestria Ingenieria Software 
    Universidad Politecnica Salesiana

=== LINK GITHUB
    https://github.com/ciit4ivadeveloper/Tarea3_sprintboot_Empresa_XYZ.git