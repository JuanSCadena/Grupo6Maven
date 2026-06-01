import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class PersonaTest {

  @Test
  void deberiaCrearPersona() {
    Persona persona = new Persona("Juan", 25, "juan@email.com");
    assertEquals("Juan", persona.getNombre());
    assertEquals(25, persona.getEdad());
  }

  @Test
  void deberiaVerificarQueEsAdulto() {
    Persona persona = new Persona("Maria", 30, "maria@email.com");
    assertTrue(persona.esAdulto());
  }

  @Test
  void deberiaVerificarQueNoEsAdulto() {
    Persona persona = new Persona("Pedro", 16, "pedro@email.com");
    assertFalse(persona.esAdulto());
  }

  @Test
  void deberiaEstablecerNombre() {
    Persona persona = new Persona("Juan", 25, "juan@email.com");
    persona.setNombre("Carlos");
    assertEquals("Carlos", persona.getNombre());
  }

  @Test
  void deberiaEstablecerEdad() {
    Persona persona = new Persona("Juan", 25, "juan@email.com");
    persona.setEdad(30);
    assertEquals(30, persona.getEdad());
  }

  @Test
  void deberiaEstablecerEmail() {
    Persona persona = new Persona("Juan", 25, "juan@email.com");
    persona.setEmail("newemail@domain.com");
    assertEquals("newemail@domain.com", persona.getEmail());
  }

  @Test
  void deberiaValidarEmailConFormatoValido() {
    Persona persona = new Persona("Juan", 25, "juan@gmail.com");
    assertTrue(persona.tieneEmailValido());
  }

  @Test
  void deberiaValidarEmailSinArroba() {
    Persona persona = new Persona("Juan", 25, "juangmail.com");
    assertFalse(persona.tieneEmailValido());
  }

  @Test
  void deberiaValidarEmailNulo() {
    Persona persona = new Persona("Juan", 25, null);
    assertFalse(persona.tieneEmailValido());
  }

  @Test
  void deberiaImprimirInformacion() {
    Persona persona = new Persona("Ana", 28, "ana@example.com");
    persona.imprimeInformacion();
    assertEquals("Ana", persona.getNombre());
  }
}
