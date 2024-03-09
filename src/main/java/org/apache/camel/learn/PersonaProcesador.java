package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PersonaProcesador implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
 
        Persona nuevoPersona = new Persona();
        nuevoPersona.setCodigo(12);
        nuevoPersona.setIdentificacion("0301293882");
        nuevoPersona.setNombres("Cristian Ivan");
        nuevoPersona.setApellidos("Idrovo Tapia");
        nuevoPersona.setTelefonos("0984500625");
        nuevoPersona.setDireccion("Av.Patamarca");
        nuevoPersona.setPerfilCompra(1); //1 presencial, 2 online
        nuevoPersona.setValorCompra(100.20);
        exchange.getIn().setBody(nuevoPersona);
    }
    
}
