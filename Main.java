import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Library biblioteca = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: registrarLibro(); break;
                case 2: actualizarLibro(); break;
                case 3: eliminarLibro(); break;
                case 4: buscarLibro(); break;
                case 5: ordenarLibros(); break;
                case 6: mostrarLibros(); break;
                case 0: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1. Registrar nuevo libro");
        System.out.println("2. Actualizar libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Buscar libro");
        System.out.println("5. Ordenar libros");
        System.out.println("6. Mostrar todos los libros");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarLibro() {
        System.out.println("\n-- Registro de Nuevo Libro --");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Materia: ");
        String materia = scanner.nextLine();
        System.out.print("Número de páginas: ");
        int numPaginas = scanner.nextInt();

        Book libro = new Book(codigo, nombre, autor, materia, numPaginas);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro registrado exitosamente.");
    }

    private static void buscarLibro() {
        System.out.println("\n-- Búsqueda de Libro --");
        System.out.println("1. Búsqueda secuencial");
        System.out.println("2. Búsqueda binaria");
        System.out.print("Seleccione método de búsqueda: ");
        int metodo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Escriba el campo por el cual desea hacer la búsqueda \n(codigo/nombre/autor/materia): ");
        String campo = scanner.nextLine();
        System.out.print("Valor a buscar: ");
        String valor = scanner.nextLine();

        Book encontrado = (metodo == 1) ? 
            biblioteca.busquedaSecuencial(campo, valor) : 
            biblioteca.busquedaBinaria(campo, valor);

        if (encontrado != null) {
            System.out.println("Libro encontrado:");
            mostrarLibro(encontrado);
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    private static void ordenarLibros() {
        System.out.println("\n-- Ordenar Libros --");
        System.out.println("1. Método burbuja");
        System.out.println("2. Método selección");
        System.out.print("Seleccione método de ordenamiento: ");
        int metodo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Escriba el campo por el cual desea hacer el orden \n(codigo/nombre/autor/materia): ");
        String campo = scanner.nextLine();

        if (metodo == 1) {
            biblioteca.ordenarBurbuja(campo);
        } else {
            biblioteca.ordenarSeleccion(campo);
        }
        System.out.println("Los libros fueron ordenados exitosamente.");
    }

    private static void mostrarLibros() {
        System.out.println("\n-- Lista de Libros --");
        for (Book libro : biblioteca.getBooks()) {
            mostrarLibro(libro);
        }
    }

    private static void mostrarLibro(Book libro) {
        System.out.println("Código: " + libro.getCodigo());
        System.out.println("Nombre: " + libro.getNombre());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Materia: " + libro.getMateria());
        System.out.println("Páginas: " + libro.getNumPaginas());
        System.out.println("------------------------");
    }

    private static void actualizarLibro() {
        System.out.println("\n-- Actualizar Libro --");
        System.out.print("Ingrese el código del libro que desea actualizar: ");
        String codigo = scanner.nextLine();
        
        System.out.println("Ingrese los nuevos datos:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Materia: ");
        String materia = scanner.nextLine();
        System.out.print("Número de páginas: ");
        int numPaginas = scanner.nextInt();

        Book nuevoLibro = new Book(codigo, nombre, autor, materia, numPaginas);
        if (biblioteca.actualizarLibro(codigo, nuevoLibro)) {
            System.out.println("El Libro fue actualizado exitosamente.");
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    private static void eliminarLibro() {
        System.out.println("\n-- Eliminar Libro --");
        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = scanner.nextLine();
        
        if (biblioteca.eliminarLibro(codigo)) {
            System.out.println("El libro fue eliminado exitosamente.");
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }
}
