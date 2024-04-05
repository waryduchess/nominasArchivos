package calculoNomina;

import java.util.ArrayList;

public class calculos extends empleado {
 public static void igualarDiasEmp(ArrayList<empleado> listaEmpleados, int numeroNomina,int diasTab ) {
	 for(empleado empleado: listaEmpleados) {
		 if(empleado.numeroDeNomina == numeroNomina) {
			 empleado.diasTrabajados = diasTab;
		 }
		 
	 }
 }
 public static void ayo1(ArrayList<empleado> listaEmpleados, int numeroNomina,int ayo) {
	 for(empleado empleado: listaEmpleados) {
		 if(empleado.numeroDeNomina == numeroNomina) {
			empleado.ayoDeLaNomina = ayo;
		 }
		 
	 }
 }
 public static void mes(ArrayList<empleado> listaEmpleados, int numeroNomina, int mes ) {
	 for(empleado empleado: listaEmpleados) {
		 if(empleado.numeroDeNomina == numeroNomina) {		
			empleado.mesDeLaNomina = mes;
			
		 }
		 
	 }
 }
 public static void dia(ArrayList<empleado> listaEmpleados, int numeroNomina, int dia ) {
	 for(empleado empleado: listaEmpleados) {
		 if(empleado.numeroDeNomina == numeroNomina) {
			
			
			empleado.diasDeLaNomina = dia;
			if(empleado.salarioNeto <1)
			empleado.salarioNeto = empleado.salariopDiario*empleado.diasTrabajados;
		 }
		 
	 }
 }
 public static void pago(ArrayList<empleado> listaEmpleados, int numeroNomina, double pago ) {
	 double monto = 0;
	 for(empleado empleado: listaEmpleados) {
		 if(empleado.numeroDeNomina == numeroNomina) {
			 if(empleado.salarioNeto <1) {
					monto =  empleado.salariopDiario*empleado.diasTrabajados;
					empleado.salarioNeto = monto;
					
				 }else {
					 empleado.salarioNeto = pago;
				 }
		 }
		 
	 }
 }
}
