import java.util.ArrayList;
import java.util.List;

//Creamos una clase nodo con el objetivo de representar los nodos en la red
class Nodo {
    int id; //identificador
    double trafico; //trafico

    public Nodo(int id) {
        this.id = id;
        this.trafico = 0;
    }
}

public class SimulacionRed {

    public static List<Nodo> crearRed(int numeroNodos) { //recibe el numero de nodos y posteriormente devuelve una lista de nodos
        List<Nodo> red = new ArrayList<>();
        for (int i = 0; i < numeroNodos; i++) {
            red.add(new Nodo(i));
        }
        return red;
    }


    public static void simularTrafico(Nodo nodo, double tasaTrafico) { //recibe un nodo y una tasa de trafico
        nodo.trafico = tasaTrafico * nodo.id; //nivel de trafico = tasa de trafico por identificador del nodo
    }

    public static void simularRed(List<Nodo> nodos, double tasaTrafico) {
        for (Nodo nodo : nodos) {
            simularTrafico(nodo, tasaTrafico);
            System.out.println("Nodo: " + nodo.id + " - Tráfico: " + nodo.trafico);
        }
    }


    public static List<Nodo> generarNodos(int cantidad) { // recibe una cantidad y devuleve una lista de nodos
        List<Nodo> nodos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            nodos.add(new Nodo(i));
        }
        return nodos;
    }

    public static void main(String[] args) {

        int numeroNodos = 10;
        double tasaTrafico = 0.5;


        List<Nodo> nodos = generarNodos(numeroNodos); //generador de nodos


        simularRed(nodos, tasaTrafico); //simulacion en la red
    }
}
