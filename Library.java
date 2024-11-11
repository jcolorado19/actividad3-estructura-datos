import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void agregarLibro(Book libro) {
        books.add(libro);
    }

    public boolean actualizarLibro(String codigo, Book nuevoLibro) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCodigo().equals(codigo)) {
                books.set(i, nuevoLibro);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarLibro(String codigo) {
        return books.removeIf(book -> book.getCodigo().equals(codigo));
    }

    public Book busquedaSecuencial(String campo, String valor) {
        for (Book book : books) {
            switch (campo.toLowerCase()) {
                case "codigo": if (book.getCodigo().equals(valor)) return book; break;
                case "nombre": if (book.getNombre().equals(valor)) return book; break;
                case "autor": if (book.getAutor().equals(valor)) return book; break;
                case "materia": if (book.getMateria().equals(valor)) return book; break;
            }
        }
        return null;
    }

    public Book busquedaBinaria(String campo, String valor) {
        ordenarBurbuja(campo); // Ordenar antes de búsqueda binaria
        int inicio = 0, fin = books.size() - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = compararCampo(books.get(medio), campo, valor);
            
            if (comparacion == 0) return books.get(medio);
            if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }
        return null;
    }

    public void ordenarBurbuja(String campo) {
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - i - 1; j++) {
                if (compararCampo(books.get(j), campo, getCampoValor(books.get(j + 1), campo)) > 0) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarSeleccion(String campo) {
        for (int i = 0; i < books.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < books.size(); j++) {
                if (compararCampo(books.get(j), campo, getCampoValor(books.get(min), campo)) < 0) {
                    min = j;
                }
            }
            Book temp = books.get(i);
            books.set(i, books.get(min));
            books.set(min, temp);
        }
    }

    private int compararCampo(Book libro, String campo, String valor) {
        switch (campo.toLowerCase()) {
            case "codigo": return libro.getCodigo().compareTo(valor);
            case "nombre": return libro.getNombre().compareTo(valor);
            case "autor": return libro.getAutor().compareTo(valor);
            case "materia": return libro.getMateria().compareTo(valor);
            default: return 0;
        }
    }

    private String getCampoValor(Book libro, String campo) {
        switch (campo.toLowerCase()) {
            case "codigo": return libro.getCodigo();
            case "nombre": return libro.getNombre();
            case "autor": return libro.getAutor();
            case "materia": return libro.getMateria();
            default: return "";
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

