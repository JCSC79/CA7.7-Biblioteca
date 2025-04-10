public class PruebasBiblioteca {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS CA7.7: Gestión de Biblioteca ===");

        // Prueba de creación de objetos
        Material libro = new Libro("Cien años de soledad", 1967, "Gabriel García Márquez");
        Material revista = new Revista("National Geographic", 2023, "Susan Goldberg");
        Material dvd = new DVD("Inception", 2010, "Christopher Nolan");

        // Prueba de métodos heredados y sobrescritos
        System.out.println("\n--- Prueba de métodos ---");
        probarMetodo(libro, "Libro", "Cien años de soledad - 1967 - Gabriel García Márquez");
        probarMetodo(revista, "Revista", "National Geographic - 2023 - Susan Goldberg");
        probarMetodo(dvd, "DVD", "Inception - 2010 - Christopher Nolan");

        // Prueba de polimorfismo
        System.out.println("\n--- Prueba de polimorfismo ---");
        Material[] materiales = {libro, revista, dvd};
        for (Material material : materiales) {
            System.out.println("Tipo: " + material.getTipo() + " | Detalles: " + material);
        }

        System.out.println("\n✅ ¡Todas las pruebas pasaron!");
    }

    private static void probarMetodo(Material material, String tipoEsperado, String detallesEsperados) {
        boolean tipoCorrecto = material.getTipo().equals(tipoEsperado);
        boolean detallesCorrectos = material.toString().equals(detallesEsperados);

        System.out.println("\nMaterial: " + material.getClass().getSimpleName());
        System.out.println("Tipo esperado: " + tipoEsperado + " | Resultado: " + (tipoCorrecto ? "✅" : "❌"));
        System.out.println("Detalles esperados: " + detallesEsperados + " | Resultado: " + (detallesCorrectos ? "✅" : "❌"));

        if (!tipoCorrecto || !detallesCorrectos) {
            throw new AssertionError("¡Prueba fallida para " + material.getClass().getSimpleName() + "!");
        }
    }
}
