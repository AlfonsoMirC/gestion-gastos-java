import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");
    }

    public static void mostrarResumen(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        double total = calcularTotal(montos);
        int numeroGastos = montos.size();

        double promedio = 0;

        if (!montos.isEmpty()) {
            promedio = total / numeroGastos;
        }

        int posicionMayor = obtenerPosicionGastoMayor(montos);

        System.out.println("RESUMEN SEMANAL");
        System.out.println();

        System.out.println("Número de gastos: " + numeroGastos);
        System.out.printf("Gasto total: $%.2f%n", total);
        System.out.printf("Promedio por gasto: $%.2f%n", promedio);

        if (posicionMayor != -1) {
            System.out.printf(
                    "Gasto mayor: %s, $%.2f%n",
                    conceptos.get(posicionMayor),
                    montos.get(posicionMayor)
            );
        } else {
            System.out.println("Gasto mayor: No hay gastos registrados");
        }
    }

    public static double calcularTotal(ArrayList<Double> montos) {

        double total = 0;

        for (int i = 0; i < montos.size(); i++) {
            total += montos.get(i);
        }

        return total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos) {

        if (montos.isEmpty()) {
            return -1;
        }

        int posicionMayor = 0;

        for (int i = 1; i < montos.size(); i++) {

            if (montos.get(i) > montos.get(posicionMayor)) {
                posicionMayor = i;
            }
        }

        return posicionMayor;
    }

    public static double calcularTotalPorCategoria(
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            String categoriaBuscada) {

        double total = 0;

        for (int i = 0; i < categorias.size(); i++) {

            if (categorias.get(i).equals(categoriaBuscada)) {
                total += montos.get(i);
            }
        }

        return total;
    }
}
// Calcular total de montos (calcularTotal(montons))
//  Crear una variable total y asignarle 0.
//  Recorrer la lista montos desde la primera posicion hasta la ultima.
//  En cada posición sumar el monto actual a total y regresar total

// Metodo obtenerPosicionGastoMayor(montos)
//    Verificar si la lista montos está vacía.
//    Si esta vacia regresa 0.
//    Si no está vacía se crea la variable posicionMayor y asignarle 0.
//    Recorre la lista desde la segunda posición hasta la última.
//    Comparar el monto actual con el monto ubicado en posicionMayor.
//    Si el monto actual es mayor:
//    Actualizar posicionMayor con la posición actual.
//    Regresar posicionMayor.