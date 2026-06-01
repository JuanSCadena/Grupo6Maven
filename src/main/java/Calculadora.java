public class Calculadora {

    private String nombre = "Calculadora v1.0";
    private int operacionesRealizadas = 0;
    // Variable no utilizada - Problema PMD 1
    private String codigoLicencia = "LIC-12345";

    public Calculadora() {
    }

    public int sumar(int a, int b) {
        operacionesRealizadas++;
        int resultado = a + b;
        return resultado;
    }

    public int restar(int a, int b) {
        operacionesRealizadas++;
        return a - b;
    }

    public int multiplicar(int a, int b) {
        operacionesRealizadas++;
        // Línea muy larga - Problema Checkstyle 1
        System.out.println("Realizando multiplicación de " + a + " por " + b + " en la calculadora");
        return a * b;
    }

    public int dividir(int a, int b) {
        // Bloque catch vacío - Problema PMD 2
        try {
            if (b == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
        } catch (ArithmeticException e) {
        }

        operacionesRealizadas++;
        return a / b;
    }

    public int obtenerOperacionesRealizadas() {
        return operacionesRealizadas;
    }

    public boolean esMayorQue(int a, int b) {
        // Comparación incorrecta - Problema PMD 3
        Integer x = a;
        Integer y = b;
        return x == y;
    }

    public void resetearOperaciones() {
        operacionesRealizadas = 0;
    }
}
