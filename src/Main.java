import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Mostrar el titulo
        System.out.println("Gestor semanal de gastos");

        // Arreglos para almacenar los datos
        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();

        // Scanner principal
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menu de opciones
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n***** MENU *****");
            System.out.println("1) Registrar gasto");
            System.out.println("2) Mostrar gastos");
            System.out.println("3) Mostrar resumen");
            System.out.println("4) Salir");
            System.out.println("Elige una opcion:");

            opcion = scanner.nextInt();

            if (opcion == 1) {

                registrarGasto(conceptos, categorias, montos, scanner);

            } else if (opcion == 2) {

                mostrarGastos(conceptos, categorias, montos);

            } else if (opcion == 3) {

                mostrarResumen(conceptos, categorias, montos);

            } else if (opcion == 4) {

                System.out.println("Programa terminado.");

            } else {

                System.out.println("Error: Elige una opcion valida.");

            }
        }

        scanner.close();
    }


    // METODO PARA MOSTRAR EL RESUMEN

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

        System.out.println("\n***** RESUMEN SEMANAL *****");
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

            System.out.println(
                    "Gasto mayor: No hay gastos registrados"
            );
        }
    }


    // METODO PARA CALCULAR EL TOTAL

    public static double calcularTotal(
            ArrayList<Double> montos) {

        double total = 0;

        for (int i = 0; i < montos.size(); i++) {

            total += montos.get(i);
        }

        return total;
    }


    // METODO PARA OBTENER LA POSICION DEL GASTO MAYOR

    public static int obtenerPosicionGastoMayor(
            ArrayList<Double> montos) {

        // Verificar si la lista está vacía
        if (montos.isEmpty()) {

            return -1;
        }

        // Suponer inicialmente que el mayor está
        // en la primera posición
        int posicionMayor = 0;

        // Recorrer desde la segunda posición
        for (int i = 1; i < montos.size(); i++) {

            // Comparar el monto actual con el mayor encontrado
            if (montos.get(i) > montos.get(posicionMayor)) {

                posicionMayor = i;
            }
        }

        return posicionMayor;
    }

    // METODO PARA CALCULAR TOTAL POR CATEGORIA

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

    // METODO PARA REGISTRAR UN GASTO

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {

        // Declaracion de variables temporales
        String concepto;
        String categoria;
        double monto;
        int categInt;

        // INGRESAR EL CONCEPTO

        System.out.println("\nIntroduce el concepto:");

        // nextLine permite introducir espacios
        scanner.nextLine();
        concepto = scanner.nextLine();


        // INGRESAR LA CATEGORIA

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

            // Verificar que la categoria sea valida
            if (categInt < 1 || categInt > 5) {

                System.out.println(
                        "Error: Elige una categoria valida."
                );

                r = 0;

            } else if (categInt == 1) {

                categoria = "Materiales";
                r = 1;

                guardarGasto(
                        concepto,
                        categoria,
                        scanner,
                        conceptos,
                        categorias,
                        montos
                );

                return;

            } else if (categInt == 2) {

                categoria = "Transporte";
                r = 1;

                guardarGasto(
                        concepto,
                        categoria,
                        scanner,
                        conceptos,
                        categorias,
                        montos
                );

                return;

            } else if (categInt == 3) {

                categoria = "Alimentos";
                r = 1;

                guardarGasto(
                        concepto,
                        categoria,
                        scanner,
                        conceptos,
                        categorias,
                        montos
                );

                return;

            } else if (categInt == 4) {

                categoria = "Entretenimiento";
                r = 1;

                guardarGasto(
                        concepto,
                        categoria,
                        scanner,
                        conceptos,
                        categorias,
                        montos
                );

                return;

            } else if (categInt == 5) {

                categoria = "Otros";
                r = 1;

                guardarGasto(
                        concepto,
                        categoria,
                        scanner,
                        conceptos,
                        categorias,
                        montos
                );

                return;
            }
        }
    }


    // METODO PARA GUARDAR EL GASTO

    public static void guardarGasto(
            String concepto,
            String categoria,
            Scanner scanner,
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        double monto;
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

            } else {

                // Guardar los datos
                conceptos.add(concepto);
                categorias.add(categoria);
                montos.add(monto);

                montoValido = 1;

                System.out.println(
                        "Gasto registrado correctamente."
                );
            }
        }
    }


    // METODO PARA MOSTRAR LOS GASTOS

    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        System.out.println("\n***** GASTOS REGISTRADOS *****");

        // Verificar si existen gastos
        if (conceptos.size() == 0) {

            System.out.println(
                    "No hay gastos registrados."
            );

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

            System.out.printf(
                    "%d | %s | %s | $%.2f%n",
                    i + 1,
                    conceptos.get(i),
                    categorias.get(i),
                    montos.get(i)
            );
        }
    }
}