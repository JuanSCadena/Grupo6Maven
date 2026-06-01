public class Persona {

    private String nombre;
    private int edad;
    private String email;
    // Variable no utilizada - Problema PMD 1
    private String telefonoEmergencia;

    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Línea muy larga sin necesidad - Problema Checkstyle 1
        if (nombre != null && nombre.length() > 0 && !nombre.isEmpty() && nombre.matches("[a-zA-Z ]+")) {
            this.nombre = nombre;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad < 150) {
            this.edad = edad;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean esAdulto() {
        return edad >= 18;
    }

    public boolean tieneEmailValido() {
        // Bloque catch vacío - Problema PMD 2
        try {
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Email inválido");
            }
        } catch (IllegalArgumentException e) {
        }
        return email != null && email.contains("@");
    }

    public void imprimeInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Email: " + email);
    }
}
