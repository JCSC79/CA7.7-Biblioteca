public class Revista extends Material {  
    private String editor;  

    public Revista(String titulo, int añoPublicacion, String editor) {  
        super(titulo, añoPublicacion);  
        this.editor = editor;  
    }  

    @Override  
    public String getTipo() {  
        return "Revista";  
    }  

    @Override  
    public String toString() {  
        return super.toString() + " - " + editor;  
    }  
}  
