/**
 * Clase Calculadora que realiza operaciones matemáticas básicas.
 * Proporciona métodos para suma, resta, multiplicación y división.
 */
public class Calculadora {

  private int operacionesRealizadas = 0;

  /**
   * Constructor por defecto de Calculadora.
   */
  public Calculadora() {
  }

  /**
   * Suma dos números enteros.
   *
   * @param a primer número
   * @param b segundo número
   * @return la suma de a + b
   */
  public int sumar(int a, int b) {
    operacionesRealizadas++;
    int resultado = a + b;
    return resultado;
  }

  /**
   * Resta dos números enteros.
   *
   * @param a minuendo
   * @param b sustraendo
   * @return la resta de a - b
   */
  public int restar(int a, int b) {
    operacionesRealizadas++;
    return a - b;
  }

  /**
   * Multiplica dos números enteros.
   *
   * @param a primer número
   * @param b segundo número
   * @return el producto de a * b
   */
  public int multiplicar(int a, int b) {
    operacionesRealizadas++;
    return a * b;
  }

  /**
   * Divide dos números enteros.
   *
   * @param a dividendo
   * @param b divisor
   * @return el cociente de a / b
   * @throws ArithmeticException si b es cero
   */
  public int dividir(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("No se puede dividir por cero");
    }
    operacionesRealizadas++;
    return a / b;
  }

  /**
   * Obtiene la cantidad de operaciones realizadas.
   *
   * @return número de operaciones
   */
  public int obtenerOperacionesRealizadas() {
    return operacionesRealizadas;
  }

  /**
   * Compara si el primer número es mayor que el segundo.
   *
   * @param a primer número
   * @param b segundo número
   * @return true si a > b, false en otro caso
   */
  public boolean esMayorQue(int a, int b) {
    return a > b;
  }

  /**
   * Reinicia el contador de operaciones realizadas.
   */
  public void resetearOperaciones() {
    operacionesRealizadas = 0;
  }
}
