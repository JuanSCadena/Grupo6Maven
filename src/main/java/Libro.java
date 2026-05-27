public class Libro {

    private String titulo;
    private String autor;
    private boolean disponible = true;

    // Problema PMD 1: campo privado declarado pero nunca utilizado.
    private String codigoInterno = "SIN-CODIGO";

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        // Problema PMD 2: uso de System.out.println en código de aplicación.
        System.out.println("Prestando libro: " + titulo);

        if (!disponible) {
            throw new IllegalStateException("Libro no disponible");
        }

        disponible = false;
    }

    public void devolver() {
        disponible = true;

        // Problema PMD 3: bloque catch vacío.
        try {
            Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
        }
    }

    public boolean esMismoTitulo(String otroTitulo) {
        // Problema PMD 4: comparación incorrecta de String usando ==.
        return titulo == otroTitulo;
    }

    // Problema PMD 5: método privado declarado pero nunca utilizado.
    private void registrarAuditoriaInterna() {
    }
}