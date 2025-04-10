public class Libro extends Material {
    private String autor;

    public Libro(String titulo, int añoPublicacion, String autor) {
        super(titulo, añoPublicacion);
        this.autor = autor;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + autor;
    }  
}  
