# Tarea 2 Unidad 5 - Regresión Lineal por Mínimos Cuadrados

Proyecto Java para la asignatura SCC-1017 Métodos Numéricos.

## Requisitos
- JDK 17 o superior.
- Terminal o un IDE como IntelliJ IDEA.

## Clonar
```bash
git clone https://github.com/USUARIO/Tarea2-Unidad5-RegresionLineal.git
cd Tarea2-Unidad5-RegresionLineal
```
Sustituye `USUARIO` por tu usuario de GitHub y usa la URL real de tu repositorio.

## Compilar
Desde la carpeta raíz:
```bash
javac -d out src/Ajuste_de_Funciones/*.java
```

## Ejecutar
```bash
java -cp out Ajuste_de_Funciones.Main
```

## Datos de prueba
X = {1, 2, 3, 4, 5}; Y = {3, 5, 7, 9, 11}.

El resultado esperado es el modelo `Y = 1.0000 + 2.0000X`, Pearson `r = 1.0000`,
determinación `r2 = 1.0000` y predicción `Y = 13.0000` para X = 6.

## Archivos
- `RegresionLineal.java`: cálculo de mínimos cuadrados, Pearson y r2.
- `Main.java`: datos de prueba y ejecución del programa.
