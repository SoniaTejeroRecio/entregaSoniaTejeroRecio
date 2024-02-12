import java.util.List;

class Nivel { //clase nivel
    int dificultad;
    List<String> desafios;

    public Nivel(int dificultad, List<String> desafios) { //constructor
        this.dificultad = dificultad;
        this.desafios = desafios;
    }
}

public class VideojuegoEducativo {

    // Función para resolver un desafío (simulada, debe ser implementada según el juego)
    public static boolean resolverDesafio(String desafio) {
        //AQUÍ DEBE IR EL FRAGMENTO DEL CÓDIGO QUE EL USUARIO QUIERE PARA SU DEFAÍO
        return true;  // siempre devuelve "true", es decir, que siempre se resuelve el desafión
        //el usuario deberá indicar en qué situaciones se resuleve el deafío que quiere implementar
    }

    //función para imprimir por pantalla
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    //Imprimir por oantalla los datos
    public static void jugarNivel(Nivel nivel) {
        for (String desafio : nivel.desafios) {
            boolean resultado = resolverDesafio(desafio);
            imprimir("Desafío: " + desafio + " - Resultado: " + resultado);
        }
    }

    public static void main(String[] args) {

        Nivel nivel = new Nivel(1, List.of("loop", "condicional")); //creamos un objeto de tipo Nivel
        //tiene una lista que contienen elementos de tipo String y son: loop y condicional (estos son el tipo de desafíos), funciona creando una lista inalterable con dichos elementos

        jugarNivel(nivel); //le pasamos nivel como argumento. Lo que hace es iterar sobre los desafions que hemos definido en el nivel
        //una vez que estos sean resueltos, se imprimirán los resultados que hemos definido anteriormente por pantalla
    }
}
