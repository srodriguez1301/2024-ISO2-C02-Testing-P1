import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos los datos del usuario
        String nombre = leerDato(scanner, "Ingrese nombre", true);
        String apellidos = leerDato(scanner, "Ingrese apellidos", true);
        LocalDate fechaNacimiento = leerFechaValida(scanner, "Ingrese su fecha de nacimiento (YYYY-MM-DD)", true);
        String nacionalidad = leerDato(scanner, "Ingrese su país de nacimiento", false);
        String titulacion = leerDato(scanner, "Ingrese titulación", false);
        boolean certificacionIngles = leerDato(scanner, "¿Tiene certificación de inglés? (Sí/No)", false)
                .equalsIgnoreCase("Sí");
        String telefono = leerDatoValido(scanner, "Ingrese su número de teléfono", Principal::esTelefonoValido);
        String email = leerDatoValido(scanner, "Ingrese su correo electrónico", Principal::esEmailValido);

        // Creamos una instancia de Persona con los datos introducidos
        Persona persona = new Persona(
                nombre.isEmpty() ? "No especificado" : nombre,
                apellidos.isEmpty() ? "No especificado" : apellidos,
                fechaNacimiento,
                nacionalidad.isEmpty() ? "No especificado" : nacionalidad,
                titulacion.isEmpty() ? "No especificado" : titulacion,
                certificacionIngles,
                telefono,
                email
        );

        // Mostramos los datos ingresados
        System.out.println("\nDatos ingresados:\n" + persona);

        // Validaciones
        System.out.println("\nValidaciones:");
        System.out.println("Mayor de edad: " + (persona.esMayorDeEdad() ? "Sí" : "No"));
        System.out.println("Europea: " + (persona.esEuropea() ? "Sí" : "No"));
        System.out.println("Apta para doctorado: " + (persona.puedeDoctorado() ? "Sí" : "No"));
    }

    private static String leerDato(Scanner scanner, String mensaje, boolean obligatorio) {
        while (true) {
            System.out.print(mensaje + ": ");
            String input = scanner.nextLine().trim();
            if (!obligatorio || !input.isEmpty()) {
                return input;
            }
            System.out.println("Campo obligatorio.");
        }
    }

    private static LocalDate leerFechaValida(Scanner scanner, String mensaje, boolean obligatorio) {
        while (true) {
            System.out.print(mensaje + ": ");
            String input = scanner.nextLine().trim();
            if (!obligatorio && input.isEmpty()) {
                return null; // Para manejar casos no obligatorios
            }
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use el formato YYYY-MM-DD.");
            }
        }
    }

    private static String leerDatoValido(Scanner scanner, String mensaje, Validador validador) {
        while (true) {
            System.out.print(mensaje + ": ");
            String input = scanner.nextLine().trim();
            if (validador.validar(input)) {
                return input;
            }
            System.out.println("Formato inválido, vuelva a intentarlo.");
        }
    }

    private static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.length() == 9 && telefono.chars().allMatch(Character::isDigit);
    }

    private static boolean esEmailValido(String email) {
        return email != null && email.contains("@");
    }

    @FunctionalInterface
    interface Validador {
        boolean validar(String input);
    }
}

