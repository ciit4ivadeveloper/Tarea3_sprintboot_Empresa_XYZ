package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

public class PersonaProcesador implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {        
        String requestBody = exchange.getIn().getBody(String.class);
        // Eliminar "Persona" y los corchetes, luego dividir por ", "
        String[] partes = requestBody.replace("Persona [", "").replace("]", "").split(", ");

        // Crear un objeto JSON para almacenar los datos
        JSONObject jsonPersona = new JSONObject();

        // Iterar sobre los pares clave-valor y agregarlos al objeto JSON
        for (String parte : partes) {
            String[] keyValue = parte.split("=", 2); // Dividir en dos partes máximo
            String key = keyValue[0];
            String value = keyValue[1];
            // Convertir el valor numérico a Double o Integer si es necesario
            try {
                double doubleValue = Double.parseDouble(value);
                if (doubleValue % 1 == 0) { // Verificar si es un entero
                    jsonPersona.put(key, (int) doubleValue);
                } else {
                    jsonPersona.put(key, doubleValue);
                }
            } catch (NumberFormatException e) {
                // Si no se puede convertir a número, agregar como String
                jsonPersona.put(key, value);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Persona persona = objectMapper.readValue(jsonPersona.toString(), Persona.class);
        exchange.getIn().setBody(persona);
    }
    
}
