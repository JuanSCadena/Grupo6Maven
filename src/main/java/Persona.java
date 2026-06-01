/**
 * Clase Persona que representa un registro de persona con validaciones.
 * Incluye atributos básicos como nombre, edad y email.
 */
public class Persona {

  private String nombre;
  private int edad;
  private String email;

  /**
   * Constructor de Persona.
   *
   * @param nombre nombre de la persona
   * @param edad edad de la persona
   * @param email email de la persona
   */
  public Persona(String nombre, int edad, String email) {
    this.nombre = nombre;
    this.edad = edad;
    this.email = email;
  }

  /**
   * Obtiene el nombre de la persona.
   *
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre de la persona.
   *
   * @param nombre nombre a establecer
   */
  public void setNombre(String nombre) {
    if (nombre != null && !nombre.isEmpty()) {
      this.nombre = nombre;
    }
  }

  /**
   * Obtiene la edad de la persona.
   *
   * @return edad
   */
  public int getEdad() {
    return edad;
  }

  /**
   * Establece la edad de la persona.
   * Valida que esté entre 0 y 150.
   *
   * @param edad edad a establecer
   */
  public void setEdad(int edad) {
    if (edad > 0 && edad < 150) {
      this.edad = edad;
    }
  }

  /**
   * Obtiene el email de la persona.
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Establece el email de la persona.
   *
   * @param email email a establecer
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Verifica si la persona es adulta (>= 18 años).
   *
   * @return true si es adulto, false en otro caso
   */
  public boolean esAdulto() {
    return edad >= 18;
  }

  /**
   * Verifica si el email tiene un formato válido.
   *
   * @return true si el email es válido, false en otro caso
   */
  public boolean tieneEmailValido() {
    if (email == null || !email.contains("@")) {
      return false;
    }
    return email.contains(".");
  }

  /**
   * Imprime la información de la persona en consola.
   */
  public void imprimeInformacion() {
    System.out.println("Nombre: " + nombre + ", Edad: " + edad
        + ", Email: " + email);
  }
}
