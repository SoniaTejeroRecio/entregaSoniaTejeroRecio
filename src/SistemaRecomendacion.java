import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaRecomendacion {

    //Estructura de almacenamiento para las calificaciones que dan los usuarios a loso libros
    private static Map<String, Map<String, Double>> baseDeDatosCalificaciones = new HashMap<>();

    //Estructura de almacenamiento para los libros y sus actegorías
    private static Map<String, List<String>> baseDeDatosLibros = new HashMap<>();

    // Función para obtener los libros interesantes de un usuario
   /* public static List<String> obtenerLibrosInteresantes(String usuario) {
        return baseDeDatosCalificaciones.getOrDefault(usuario, new HashMap<>()).keySet();
    }

    */


    //la función obtenerlibrosInteresantes recibe como parámetro "usuario" y devuelve una lista
    //esta lista contendrá los libros considerando los intereses del usuario
    public static List<String> obtenerLibrosInteresantes(String usuario) {

        //podemos ver el uso de "getOrDefault. Sirve para que en caso de que el usuario no tenga claificaciones para los libros, se devuleva una nueva instancia de hashmap
        //en el caso de que no se hiciera eso poniéndonos en la situación de que el usuario no tienen calificaciones, devolvería null
        //En concluión, el objetivo es que siempre haya un map para cada situación para que no se lance una NullPointerException
        Map<String, Double> calificacionesUsuario = baseDeDatosCalificaciones.getOrDefault(usuario, new HashMap<>());
        return new ArrayList<>(calificacionesUsuario.keySet());
    }

    //De nuevo recibe usuatrio como parámetro y en este caso devulve un mapa que almacena las calificaciones
    public static Map<String, Double> obtenerCalificaciones(String usuario) {
        return baseDeDatosCalificaciones.getOrDefault(usuario, new HashMap<>());
    }

    //Recibe usuario como parámetro, devuleve una lista de libros recomendados
    public static List<String> recomendarLibros(String usuario) {
        List<String> librosInteresantes = obtenerLibrosInteresantes(usuario);
        Map<String, Double> calificaciones = obtenerCalificaciones(usuario);
        List<String> recomendaciones = new ArrayList<>();

        // Iterar sobre los libros interesantes y agregar aquellos que el usuario no ha calificado
        for (String libro : baseDeDatosLibros.keySet()) { //con este bucle se recorre cada libro en la estructura de almacenamiento (baseDeDatosLibros)
            //libro recibe el valor del identificador de cada libro
            if (!calificaciones.containsKey(libro)) { //vemos is el usuario ha clasificado el libro --> si devuleve true es que el libro ya ha sido clasificado
                recomendaciones.add(libro); //si el libro no ha sido calificado, se añade a la lista de recomendaciones ya que esto significa que el usuario no lo ha leído todavía
            }
        }

        return recomendaciones;
    }

    //función "calificarLibro"

    public static void calificarLibro(String usuario, String libro, double calificacion) {
        baseDeDatosCalificaciones
                .computeIfAbsent(usuario, k -> new HashMap<>()) //computeIfAbsent es un método de la interfaz Map, se utiliza para calcular un valor si la clave es nula, se crea un nuevo HashMap asociandolo con la clave "usuario"
                .put(libro, calificacion); //para poner la clasificación al libro
    }

    public static void main(String[] args) {
        //pruebas
        baseDeDatosLibros.put("Libro1", List.of("Interés1", "Interés2"));
        baseDeDatosLibros.put("Libro2", List.of("Interés2", "Interés3"));

        String miUsuario = "Usuario1";

        //Lista de recomendaciones para mi usuario
        List<String> recomendaciones = recomendarLibros(miUsuario);

        //Imprimir por pantalla la información
        System.out.println("Recomendaciones para " + miUsuario + ": " + recomendaciones);
    }
}

