package calculoNomina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MenuMain extends calculos{
  
   static  ArrayList<empleado> listaEmpleados = new ArrayList<>();

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
    }
}