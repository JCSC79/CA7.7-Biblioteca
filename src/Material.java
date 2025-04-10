public abstract class Material {  
    protected String titulo;  
    protected int añoPublicacion;  

    public Material(String titulo, int añoPublicacion) {  
        this.titulo = titulo;  
        this.añoPublicacion = añoPublicacion;  
    }  

    public abstract String getTipo();  

    @Override  
    public String toString() {  
        return titulo + " - " + añoPublicacion;  
    }  
}