package calculoNomina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMain extends calculos {
  
    static ArrayList<empleado> listaEmpleados = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String archivoEmpleados = "C:\\Users\\chopper\\Desktop\\POO project\\nominasArchivos\\calculoNomina\\nominas.txt";
        String diasTrab = "C:\\Users\\chopper\\Desktop\\POO project\\nominasArchivos\\calculoNomina\\diasTrabajados.txt";
        String historialNom = "C:\\Users\\chopper\\Desktop\\POO project\\nominasArchivos\\calculoNomina\\montoPago.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(", ");
                int numeroNomina = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double salarioDiario = Double.parseDouble(datos[2]);

                empleado empleado = new empleado();
                empleado.numeroDeNomina = numeroNomina;
                empleado.nombre = nombre;
                empleado.salariopDiario = salarioDiario;

                listaEmpleados.add(empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(diasTrab))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(", ");
                int numeroNomina = Integer.parseInt(datos[0]);
                int diasTarb = Integer.parseInt(datos[1]);
                igualarDiasEmp(listaEmpleados,numeroNomina,diasTarb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(historialNom))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(", ");
                int numeroNomina = Integer.parseInt(datos[0]);
                int ayo = Integer.parseInt(datos[1]);
                int mes = Integer.parseInt(datos[2]);
                int dia = Integer.parseInt(datos[3]);
                double pago = Double.parseDouble(datos[4]);
                ayo1(listaEmpleados,numeroNomina,ayo);
                mes(listaEmpleados,numeroNomina,mes);
                dia(listaEmpleados,numeroNomina,dia);
                pago(listaEmpleados,numeroNomina,pago);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        System.out.println(listaEmpleados.get(0));

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Mostrar información de los empleados");
            System.out.println("2. Realizar otro tipo de procesamiento");
            System.out.println("3. Actualizar datos de un empleado");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInformacionEmpleados(listaEmpleados);
                    break;
                case 2:
                	  System.out.println("dame el numero de empleado para agregar sus dias trabajados");
                	int numeroEmpleado =scanner.nextInt();
                	actualizarEmpleado( listaEmpleados, numeroEmpleado);
                  
                    break;
                case 3:
                    System.out.print("Ingrese el número de nómina del empleado que desea actualizar: ");
                    int numNomina = scanner.nextInt();
                    actualizarEmpleado(listaEmpleados, numNomina);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void actualizarEmpleado(ArrayList<empleado> listaEmpleados, int numeroEmpleado) {
        empleado empleadoActualizado = null;
        // Encuentra el empleado y actualiza sus datos
        for (empleado emp : listaEmpleados) {
            if (emp.numeroDeNomina == numeroEmpleado) {
                System.out.println("Por favor, introduce los datos de la nómina:");
                System.out.print("Ingrese el año de emisión de la nómina: ");
                int año = scanner.nextInt();
                System.out.print("Ingrese el mes de emisión de la nómina en sistema numérico (1-12): ");
                int mes = scanner.nextInt();
                System.out.print("Ingrese el dia de emision de la nimina ");
                int dia = scanner.nextInt();
                System.out.print("Ingrese la cantidad de días trabajados: ");
                int trab = scanner.nextInt();
   
                emp.ayoDeLaNomina = año;
                emp.mesDeLaNomina = mes;
                emp.diasDeLaNomina = dia;
                emp.diasTrabajados = trab;
                emp.salarioNeto = emp.salariopDiario*trab;
                empleadoActualizado = emp;
                break;
            }
        }
        
        if (empleadoActualizado != null) {
            try {
                PrintWriter writer = new PrintWriter("montoPago.txt", "UTF-8");
                for (empleado emp : listaEmpleados) {
                    writer.println(emp.numeroDeNomina + ", " +                                   
                                   emp.ayoDeLaNomina + ", " +
                                   emp.mesDeLaNomina + ", " +                                                                
                                   emp.salarioNeto);
                }
                writer.close();
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró un empleado con el número " + numeroEmpleado);
        }

    }
}
