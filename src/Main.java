import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Mostar el titulo
        System.out.println("Gestor semanal de gastos");

        // Arreglos para almacenar los datos
        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();

        // Scanner principal
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menu de opciones
        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\n***** MENU *****");
            System.out.println("1) Registrar gasto");
            System.out.println("2) Mostrar gastos");
            System.out.println("3) Salir");
            System.out.println("Elige una opcion:");

            opcion = scanner.nextInt();

            if (opcion == 1) {

                registrarGasto(conceptos, categorias, montos, scanner);

            }
            else if (opcion == 2) {

                mostrarGastos(conceptos, categorias, montos);

            }
            else if (opcion == 3) {

                System.out.println("Programa terminado.");

            }
            else {

                System.out.println("Error: Elige una opcion valida.");

            }
        }

        scanner.close();
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

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {

        // Declaracion de variables temporales
        String concepto;
        String categoria = "null";
        double monto;
        int categInt;

        // Ingresar el concepto
        System.out.println("\nIntroduce el concepto:");

        // Capturar el concepto
        concepto = scanner.next();

        // Ingresar el numero de categoria
        int r = 0;

        while (r == 0) {

            System.out.println(
                    "Elige la categoria:\n" +
                            "1) Materiales\n" +
                            "2) Transporte\n" +
                            "3) Alimentos\n" +
                            "4) Entretenimiento\n" +
                            "5) Otros"
            );

            categInt = scanner.nextInt();

            // Asociar categoria
            if (categInt < 1 || categInt > 5) {

                System.out.println("Error: Elige una categoria valida");
                r = 0;

            }
            else if (categInt == 1) {

                categoria = "Materiales";
                r = 1;

            }
            else if (categInt == 2) {

                categoria = "Transporte";
                r = 1;

            }
            else if (categInt == 3) {

                categoria = "Alimentos";
                r = 1;

            }
            else if (categInt == 4) {

                categoria = "Entretenimiento";
                r = 1;

            }
            else if (categInt == 5) {

                categoria = "Otros";
                r = 1;

            }
        }


        // Ingresar el monto
        int montoValido = 0;

        while (montoValido == 0) {

            System.out.println("Introduce el monto:");

            monto = scanner.nextDouble();

            // Verificar que el monto sea mayor a 0
            if (monto <= 0) {

                System.out.println(
                        "Error: El monto debe ser mayor a 0."
                );

                montoValido = 0;

            }
            else {

                // Guardar los datos
                conceptos.add(concepto);
                categorias.add(categoria);
                montos.add(monto);

                montoValido = 1;

                System.out.println("Gasto registrado correctamente.");

            }
        }
    }


    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        System.out.println("\n***** GASTOS REGISTRADOS *****");

        // Verificar si existen gastos
        if (conceptos.size() == 0) {

            System.out.println("No hay gastos registrados.");
            return;
        }

        // Mostrar encabezado
        System.out.println(
                "No. | Concepto | Categoria | Monto"
        );

        System.out.println(
                "------------------------------------------"
        );

        // Recorrer los arreglos
        for (int i = 0; i < conceptos.size(); i++) {

            System.out.println(
                    (i + 1) + " | " +
                            conceptos.get(i) + " | " +
                            categorias.get(i) + " | $" +
                            montos.get(i)
            );
        }
    }
}
