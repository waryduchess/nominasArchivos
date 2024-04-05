package calculoNomina;

public class empleado {
public int numeroDeNomina;
public String nombre;
public double salariopDiario;
public int diasTrabajados;
public int ayoDeLaNomina;
public int mesDeLaNomina;
public int diasDeLaNomina;
public double salarioNeto;

public String toString() {
    return "Número de Nómina: " + numeroDeNomina
    		+ ", Nombre: " + nombre +
    		", Salario Diario: " + salariopDiario +
    		", Días Trabajados: " + diasTrabajados +
    		", Año de la Nómina: " + ayoDeLaNomina + 
    		", Mes de la Nómina: " + mesDeLaNomina + 
    		", Días de la Nómina: " + diasDeLaNomina + 
    		", Salario Neto: " + salarioNeto;
}
}
