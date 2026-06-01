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

    // Métodos no probados: setNombre(), setEdad(), setEmail(), tieneEmailValido(), imprimeInformacion()
    // Esto causará baja cobertura en JaCoCo
}
