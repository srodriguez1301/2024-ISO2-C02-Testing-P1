package _ISO2_C02_Testing_P1_main._ISO2_C02_Testing_P1;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String titulacion;
    private boolean certIngles;
    private String telefono;
    private String email;

    // Constructor para inicializar una Persona con validaciones
    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento, 
                   String nacionalidad, String titulacion, boolean certIngles, 
                   String telefono, String email) throws IllegalArgumentException {
        if (!validarNombre(nombre)) throw new IllegalArgumentException("Nombre inválido");
        if (!validarApellidos(apellidos)) throw new IllegalArgumentException("Apellidos inválidos");
        if (!validarFechaNacimiento(fechaNacimiento)) throw new IllegalArgumentException("Fecha de nacimiento inválida");
        if (!validarNacionalidad(nacionalidad)) throw new IllegalArgumentException("Nacionalidad inválida");
        if (!validarTitulacion(titulacion)) throw new IllegalArgumentException("Titulación inválida");
        if (!validarEmail(email)) throw new IllegalArgumentException("Email inválido");
        if (!validarTelefono(telefono)) throw new IllegalArgumentException("Teléfono inválido");

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.titulacion = titulacion;
        this.certIngles = certIngles;
        this.telefono = telefono;
        this.email = email;
    }

    // Método para verificar si es mayor de edad
    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }

    // Método para verificar si es europea
    public boolean esEuropea() {
        String[] paisesEuropeos = {"España", "Francia", "Alemania", "Italia", "Portugal"};
        return Arrays.asList(paisesEuropeos).contains(this.nacionalidad);
    }

    // Método para verificar si puede matricularse en un doctorado
    public boolean puedeDoctorado() {
        return this.titulacion.equalsIgnoreCase("Máster") || this.titulacion.equalsIgnoreCase("Doctorado");
    }

    // Método auxiliar para calcular la edad
    private int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    // Métodos de validación
    private boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    private boolean validarApellidos(String apellidos) {
        return apellidos != null && !apellidos.trim().isEmpty();
    }

    private boolean validarFechaNacimiento(LocalDate fechaNacimiento) {
        return fechaNacimiento != null && fechaNacimiento.isBefore(LocalDate.now());
    }

    private boolean validarNacionalidad(String nacionalidad) {
        return nacionalidad != null && !nacionalidad.trim().isEmpty();
    }

    private boolean validarTitulacion(String titulacion) {
        return titulacion != null && (titulacion.equalsIgnoreCase("Licenciatura") || 
                                      titulacion.equalsIgnoreCase("Máster") || 
                                      titulacion.equalsIgnoreCase("Doctorado"));
    }

    private boolean validarEmail(String email) {
        return email != null && email.contains("@");
    }

    private boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\d{9}");
    }

    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + 
               "Apellidos: " + apellidos + "\n" + 
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Nacionalidad: " + nacionalidad + "\n" + 
               "Titulación: " + titulacion + "\n" + 
               "Certificación de inglés: " + (certIngles ? "Sí" : "No") + "\n" +
               "Teléfono: " + telefono + "\n" + 
               "Correo electrónico: " + email;
    }
}



