package Ajuste_de_Funciones;

/**
 * Implementa la regresion lineal simple por minimos cuadrados,
 * el coeficiente de correlacion de Pearson y el coeficiente R^2.
 */
public class RegresionLineal {

    /**
     * Retorna los coeficientes {beta0, beta1, r, r2}.
     */
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException(
                "Los arreglos deben tener el mismo tamano y al menos dos datos.");
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }

        double denominadorX = n * sumX2 - sumX * sumX;
        double denominadorR = (n * sumX2 - sumX * sumX)
                            * (n * sumY2 - sumY * sumY);

        if (Math.abs(denominadorX) < 1e-12) {
            throw new IllegalArgumentException(
                "No se puede calcular la regresion: todos los valores de X son iguales.");
        }
        if (Math.abs(denominadorR) < 1e-12) {
            throw new IllegalArgumentException(
                "No se puede calcular Pearson: X o Y no presenta variacion.");
        }

        double beta1 = (n * sumXY - sumX * sumY) / denominadorX;
        double beta0 = (sumY - beta1 * sumX) / n;

        double pearsonR = (n * sumXY - sumX * sumY) / Math.sqrt(denominadorR);
        double r2 = pearsonR * pearsonR;

        System.out.println("--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---");
        System.out.printf("Sumatorias: n= %d, X= %.1f, Y= %.1f, X2= %.1f, Y2= %.1f, XY= %.1f%n",
                n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf("Pendiente (beta1): %.4f%n", beta1);
        System.out.printf("Ordenada al origen (beta0): %.4f%n", beta0);
        System.out.printf("Modelo obtenido: Y = %.4f + %.4fX%n", beta0, beta1);
        System.out.printf("Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf("Coeficiente de Determinacion (r2): %.4f%n", r2);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    /** Estima Y evaluando el modelo para un valor de X. */
    public static double predecir(double beta0, double beta1, double xValor) {
        return beta0 + beta1 * xValor;
    }
}
