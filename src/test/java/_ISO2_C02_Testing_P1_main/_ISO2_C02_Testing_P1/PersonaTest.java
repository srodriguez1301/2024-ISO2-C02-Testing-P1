package _ISO2_C02_Testing_P1_main._ISO2_C02_Testing_P1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class PersonaTest {

    @Test
    public void testEsMayorDeEdad() {
        Persona persona = new Persona("Juan", "Pérez", LocalDate.of(2010, 8, 15),
            "España", "Máster", true, "123456789", "juan.perez@mail.com");
        assertFalse(persona.esMayorDeEdad(), "La persona no debería ser mayor de edad");
    }

    @Test
    public void testEsEuropeo() {
        Persona persona = new Persona("Ana", "López", LocalDate.of(2000, 1, 1),
            "Francia", "Doctorado", true, "987654321", "ana.lopez@mail.com");
        assertTrue(persona.esEuropea(), "La persona debería ser europea");
    }

    @Test
    public void testPuedeMatricularseEnDoctorado() {
        Persona persona = new Persona("Luis", "García", LocalDate.of(1990, 6, 25),
            "España", "Máster", true, "112233445", "luis.garcia@mail.com");
        assertTrue(persona.puedeDoctorado(), "La persona debería poder matricularse en un doctorado");
    }

    @Test
    public void testExcepciones() {
        Exception excepcionTelefono = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Pedro", "López", LocalDate.of(2000, 8, 8), "España", "Máster", true, "12345", "mail@example.com");
        });
        assertEquals("Teléfono inválido", excepcionTelefono.getMessage());

        Exception excepcionEmail = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Ana", "Marín", LocalDate.of(1990, 5, 5), "España", "Máster", true, "123456789", "correoSinArroba");
        });
        assertEquals("Email inválido", excepcionEmail.getMessage());
    }
}
