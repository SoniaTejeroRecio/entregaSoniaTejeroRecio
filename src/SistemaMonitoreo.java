import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Rendimiento {
    int cpu;
    int memoria;

    public Rendimiento(int cpu, int memoria) {
        this.cpu = cpu;
        this.memoria = memoria;
    }
}

class Aplicacion {
    String nombre;

    public Aplicacion(String nombre) {
        this.nombre = nombre;
    }
}

public class SistemaMonitoreo {

    //funcion obtener rendimiento
    public static Rendimiento obtenerRendimiento(Aplicacion aplicacion) {
        return new Rendimiento(40, 600); //devuelve un objeto rendimiento
    }

    //funcion monitorear aplicacion
    public static void monitorearAplicacion(Aplicacion aplicacion) {
        Rendimiento rendimiento = obtenerRendimiento(aplicacion); //llama a la función obterener rendimiento
        imprimir("Aplicación: " + aplicacion.nombre + " - CPU: " + rendimiento.cpu + " - Memoria: " + rendimiento.memoria);
    }

    public static List<Aplicacion> obtenerAplicaciones() {
        // Lógica para obtener la lista de aplicaciones (simulada)
        return Arrays.asList(new Aplicacion("App1"), new Aplicacion("App2"), new Aplicacion("App3")); //creamos una instancia de la calse Aplicacion con el nombre correspondiente a la aplicación
    }                                                                                                                      //devuleve una lista de las aplicaciones

    public static void main(String[] args) {

        //llama al método obtenerAplicaciones para obtener la lista de aplicaciones, posterirmnete almacena ese dato en una variabl denominada "aplicaciones"
        List<Aplicacion> aplicaciones = obtenerAplicaciones();

        //Bucle de iteración sobre cada aplicación de la lista
        for (Aplicacion aplicacion : aplicaciones) {
            monitorearAplicacion(aplicacion); //llama a la función monitorearAplicacion para mostrar el rendimineto de cada aplicación e imprimirlo por panatalla
        }
    }

    //método definida para ser usado en dunciones que necesiatn imprimir por panatalla datos
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }


}
