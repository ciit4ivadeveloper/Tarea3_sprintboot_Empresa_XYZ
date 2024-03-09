package org.apache.camel.learn;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.spi.Registry;
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
                    // Registrar el cuerpo de la solicitud en el log
                    logger.info("Solicitud HTTP: {}", requestBody);
                } else {
                    // Si el contexto Camel no está disponible, registrar un mensaje de advertencia
                    logger.warn("El contexto Camel no está disponible.");
                }
            })
            .to("rest:post:/persona?host=localhost:5000")
            //.to("rest:post:/persona?host=localhost:5000")
            .to("log:CREATE");
    }
    
}
