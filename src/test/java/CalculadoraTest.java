import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void deberiaCrearCalculadora() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.obtenerOperacionesRealizadas());
    }

    @Test
    void deberiaSumar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    void deberiaRestar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(10, 4);
        assertEquals(6, resultado);
    }

    // Métodos no probados: multiplicar(), dividir(), esMayorQue()
    // Esto causará baja cobertura de código en JaCoCo
}
