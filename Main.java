package Ajuste_de_Funciones;

import java.io.PrintStream;

public class Main {
    static void main() {
        // Datos de prueba: relacion lineal positiva perfecta.
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {3, 5, 7, 9, 11};

        double[] resultados = RegresionLineal.calcularMinimosCuadrados(x, y);
        double beta0 = resultados[0];
        double beta1 = resultados[1];

        double xNuevo = 6;
        double estimacion = RegresionLineal.predecir(beta0, beta1, xNuevo);

        try (PrintStream printf = System.out.printf("Prediccion para X = %.1f: Y = %.4f%n",
                xNuevo, estimacion)) {
        }
    }
}
