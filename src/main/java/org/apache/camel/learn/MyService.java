package org.apache.camel.learn;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyService {
    
    @Autowired private ProducerTemplate template;

    @GetMapping(value = "/createperson")
    public String createPerson(){
        return template.requestBody("direct:crearPersona","").toString();
    }
}
