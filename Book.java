import java.util.ArrayList;

public class Book {
    private String codigo;
    private String nombre;
    private String autor;
    private String materia;
    private int numPaginas;

    public Book(String codigo, String nombre, String autor, String materia, int numPaginas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.materia = materia;
        this.numPaginas = numPaginas;
    }

    // Getters and setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }
    public String getMateria() { return materia; }
    public int getNumPaginas() { return numPaginas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setMateria(String materia) { this.materia = materia; }
    public void setNumPaginas(int numPaginas) { this.numPaginas = numPaginas; }
}