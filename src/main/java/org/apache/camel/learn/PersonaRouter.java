package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;


@Component
public class PersonaRouter extends RouteBuilder{

    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Persona.class);
    @Override
    public void configure() throws Exception {
        from("direct:crearPersona")
            .routeId("CrearPersona")
            .process(new PersonaProcesador())
            .marshal(jsonDataFormat)
            .to("rest:post:/persons?host=localhost:5000")
            .to("log:CREATE");
    }
    
}
