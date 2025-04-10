# Gestión de Biblioteca (CA7.7)  

Aplicación Java con interfaz gráfica Swing para gestionar materiales de una biblioteca.  

## Características  
- **Registro de Materiales**: Libros, revistas y DVDs.  
- **Campos de Registro**: Título, Autor, Año, Detalle.  
- **Botones de Acción**: Agregar Material, Limpiar Campos.  

## Requisitos  
- **Java 17 o Superior**: Necesario para ejecutar la aplicación.  
- **IDE o Compilador**: Puedes usar cualquier IDE (Eclipse, IntelliJ, VSCode) o compilar desde la terminal.  

## Ejecución  
Para ejecutar la aplicación, sigue estos pasos:  

1. **Compila el Código**: javac -d bin src/*.java 

2. **Ejecuta la Aplicación**: java -cp bin BibliotecaApp


## Cumplimiento de CA7.7: Jerarquía de Clases  
### **Estructura de Clases**  
*Diagrama de la jerarquía de materiales*

| Clase       | Atributos Heredados        | Atributos Específicos    | Métodos Sobrescritos      |
|-------------|----------------------------|--------------------------|---------------------------|
| `Material`  | `titulo`, `añoPublicacion` | -                        | `getTipo()`, `toString()` |
| `Libro`     |                            | `autor` (String)         | `getTipo()`, `toString()` |
| `Revista`   |                            | `editor` (String)        | `getTipo()`, `toString()` |
| `DVD`       |                            | `director` (String)      | `getTipo()`, `toString()` |


## Funcionalidad  
- **Interfaz Gráfica**: Diseño moderno con Swing, incluyendo un desplegable para el tipo de material.  
- **Validación Básica**: Los campos se limpian automáticamente después de agregar un material.  
- **Gestión de Materiales**: Uso de herencia para libros, revistas y DVDs.

## Contribuciones  
Si deseas mejorar o expandir esta aplicación, puedes hacer un fork de este repositorio y enviar una solicitud de pull request con tus cambios.  

