package ucv;

import java.text.DecimalFormat;

public class Empleados {

	// Ejercicio 02

	private double pago;
	private double sueldoBruto;
	private double descTardanzas;
	private double descFaltas;
	private double sueldoNeto;
	private static DecimalFormat df = new DecimalFormat("##0.00");

	public Empleados(String categoria, String profesion, String turno, int horasTrabajadas, int tardanzas, int faltas) {
		this.pago = pago(categoria, profesion, turno);
		this.sueldoBruto = pago * horasTrabajadas;
		this.descTardanzas = pago * tardanzas;
		this.descFaltas = 0.03 * faltas * sueldoBruto;
		this.sueldoNeto = sueldoBruto - descTardanzas - descFaltas;
	}

	private double pago(String categoria, String profesion, String turno) {
		// El sueldo minimo es de 18
		double sueldo = 18;
		// Sin importar el turno o categoria el ingeniero gana 5.0 mas
		if (profesion.equals("INGENIERO"))
			sueldo += 5;
		// Sin importar la profesion o categoria la mañana gana 2.0 mas
		if (turno.equals("MAÑANA"))
			sueldo += 2;
		// El principal gana 5 mas que el auxiliar, quien gana 5 mas que el contratado
		switch (categoria) {
		case "PRINCIPAL":
			sueldo += 5;
		case "AUXILIAR":
			sueldo += 5;
			break;
		}
		return sueldo;
	}

	public String getPago() {
		return df.format(pago);
	}

	public String getSueldoBruto() {
		return df.format(sueldoBruto);
	}

	public String getDescTardanzas() {
		return df.format(descTardanzas);
	}

	public String getDescFaltas() {
		return df.format(descFaltas);
	}

	public String getSueldoNeto() {
		return df.format(sueldoNeto);
	}
}