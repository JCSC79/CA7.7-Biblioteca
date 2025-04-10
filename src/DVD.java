public class DVD extends Material {  
    private String director;  

    public DVD(String titulo, int añoPublicacion, String director) {  
        super(titulo, añoPublicacion);  
        this.director = director;  
    }  

    @Override  
    public String getTipo() {  
        return "DVD";  
    }  

    @Override  
    public String toString() {  
        return super.toString() + " - " + director;  
    }  
}  
