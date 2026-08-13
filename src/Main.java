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