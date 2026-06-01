import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void deberiaMultiplicar() {
    Calculadora calc = new Calculadora();
    int resultado = calc.multiplicar(4, 5);
    assertEquals(20, resultado);
  }

  @Test
  void deberiaDividir() {
    Calculadora calc = new Calculadora();
    int resultado = calc.dividir(20, 4);
    assertEquals(5, resultado);
  }

  @Test
  void deberiaLanzarErrorAlDividirPorCero() {
    Calculadora calc = new Calculadora();
    assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
  }

  @Test
  void deberiaVerificarQueEsMayorQue() {
    Calculadora calc = new Calculadora();
    assertTrue(calc.esMayorQue(5, 3));
  }

  @Test
  void deberiaVerificarQueNoEsMayorQue() {
    Calculadora calc = new Calculadora();
    assertFalse(calc.esMayorQue(2, 5));
  }

  @Test
  void deberiaContarOperaciones() {
    Calculadora calc = new Calculadora();
    calc.sumar(1, 1);
    calc.restar(5, 2);
    calc.multiplicar(3, 4);
    assertEquals(3, calc.obtenerOperacionesRealizadas());
  }

  @Test
  void deberiaResetearOperaciones() {
    Calculadora calc = new Calculadora();
    calc.sumar(1, 1);
    calc.restar(5, 2);
    calc.resetearOperaciones();
    assertEquals(0, calc.obtenerOperacionesRealizadas());
  }
}
