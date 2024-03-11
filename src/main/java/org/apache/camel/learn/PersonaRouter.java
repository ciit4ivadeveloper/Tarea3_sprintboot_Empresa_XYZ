package org.apache.camel.learn;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.spi.Registry;
import org.apache.camel.util.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PersonaRouter extends RouteBuilder{
     
    @Autowired
    private CamelContext camelContext;

    private Logger logger = LoggerFactory.getLogger(PersonaRouter.class);

    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Persona.class);
    @Override
    public void configure() throws Exception {
        from("direct:crearPersona")
            .routeId("CrearPersona")
            .process(new PersonaProcesador())
            .marshal(jsonDataFormat) 
            .process(exchange -> {
                // Obtener el logger del contexto Camel
                if (camelContext != null) {
                    // Obtener la solicitud HTTP antes de ser enviada
                    String requestBody = exchange.getIn().getBody(String.class);
                            
                    // Utilizar Jackson para mapear la cadena JSON al objeto Persona
                    ObjectMapper objectMapper = new ObjectMapper();
                    Persona persona = objectMapper.readValue(requestBody, Persona.class);

                    // Obtener el valor de la etiqueta "perfilCompra" del objeto Persona
                    int perfilCompra = persona.getPerfilCompra();

                    // Guardar el valor de "perfilCompra" como una propiedad de intercambio
                    exchange.setProperty("perfilCompra", perfilCompra);

                    // Registrar el cuerpo de la solicitud en el log
                    logger.info("Solicitud HTTP: {}", requestBody);
                } else {
                    // Si el contexto Camel no está disponible, registrar un mensaje de advertencia
                    logger.warn("El contexto Camel no está disponible.");
                }
            })
            .choice()
                .when(simple("${exchangeProperty.perfilCompra} == 2")) // Verificar si perfilCompra es igual a 2 PYTHON EMPRESA 123
                    .to("rest:post:/persona?host=localhost:5000")
                .when(simple("${exchangeProperty.perfilCompra} == 1")) // Verificar si perfilCompra es igual a 1 .NET EMPRESA ABC
                    .to("rest:post:/persona?host=localhost:5045")
                .otherwise()
                    .log("PerfilCompra no válido: ${exchangeProperty.perfilCompra}") // Loguear un mensaje si perfilCompra no es 1 ni 2
            .end()
            .to("log:CREATE");
    }
    
}
