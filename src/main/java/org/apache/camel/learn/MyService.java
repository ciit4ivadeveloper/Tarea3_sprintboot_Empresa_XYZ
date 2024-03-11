package org.apache.camel.learn;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyService {
    
    @Autowired private ProducerTemplate template;

    @PostMapping(value = "/realizaCompra" , produces = "application/json")
    public String realizaCompra(@RequestBody Persona persona){
        // Enviar el objeto Persona a la ruta Camel utilizando el ProducerTemplate
        return template.requestBody("direct:crearPersona",persona).toString();

    }
}
