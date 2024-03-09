package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PersonaProcesador implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
 
        Persona nuevoPersona = new Persona();
        nuevoPersona.setCodigo(12);
        nuevoPersona.setIdentificacion("0301293882");
        nuevoPersona.setNombres("Carmen JUAN");
        nuevoPersona.setApellidos("VALO Muñoz");
        nuevoPersona.setTelefono("09845012323");
        nuevoPersona.setDireccion("Av. Americas");
        nuevoPersona.setPerfilCompra(2); //1 presencial, 2 online
        nuevoPersona.setValorCompra(17.35);
        exchange.getIn().setBody(nuevoPersona);
    }
    
}
