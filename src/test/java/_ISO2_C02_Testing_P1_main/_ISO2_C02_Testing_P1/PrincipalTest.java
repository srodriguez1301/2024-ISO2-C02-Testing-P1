package _ISO2_C02_Testing_P1_main._ISO2_C02_Testing_P1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrincipalTest {

    @Test
    public void testFlujoPrincipal() {
        // Simulamos la entrada del usuario
        String simulatedInput = String.join("\n",
            "Juan",             // Nombre
            "Pérez",            // Apellidos
            "1995-08-15",       // Fecha de nacimiento
            "España",           // Nacionalidad
            "Máster",           // Titulación
            "Sí",               // Certificación de inglés
            "123456789",        // Teléfono
            "juan.perez@mail.com" // Email
        );
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        // Capturamos la salida del programa
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Ejecutamos el método principal
        Principal.main(new String[0]);

        // Verificamos la salida esperada
        String salidaEsperada = String.join("\n",
            "Ingrese nombre: Ingrese apellidos: Ingrese su fecha de nacimiento (YYYY-MM-DD): " +
            "Ingrese su país de nacimiento: Ingrese titulación: ¿Tiene certificación de inglés? (Sí/No): " +
            "Ingrese su número de teléfono: Ingrese su correo electrónico: ",
            "",
            "Datos ingresados:",
            "Nombre: Juan",
            "Apellidos: Pérez",
            "Fecha de nacimiento: 1995-08-15",
            "Nacionalidad: España",
            "Titulación: Máster",
            "Certificación de inglés: Sí",
            "Teléfono: 123456789",
            "Correo electrónico: juan.perez@mail.com",
            "",
            "Validaciones:",
            "Mayor de edad: Sí",
            "Europea: Sí",
            "Apta para doctorado: Sí"
        );

        String salidaReal = output.toString().replaceAll("\\s+", " ").trim();
        String salidaEsperadaModificada = salidaEsperada.replaceAll("\\s+", " ").trim();
        
        assertEquals(salidaEsperadaModificada, salidaReal);
    }
}
