package ucv;

public class Empleados {

	private String codigo;
	private String nombre;
	private String area;
	private double sueldoBase;
	private double horasExtras;
	private String tipo_seg;
	
	public Empleados(String codigo, String nombre, String area, double sueldoBase, double horasExtras,
			String tipo_seg) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.area = area;
		this.sueldoBase = sueldoBase;
		this.horasExtras = horasExtras;
		this.tipo_seg = tipo_seg;
	}
	
	public double montoHExtras() {
		return (sueldoBase * horasExtras) / 240;
	}
	
	public double montoSeguro() {
		if(tipo_seg.equals("AFP")) {
			return 0.17 * sueldoBase;
		}
		return 0.05 * sueldoBase;
	}
	
	public double montoEssalud() {
		return 0.03 * sueldoBase;
	}
	
	public double montoDescuentos() {
		return montoSeguro() + montoEssalud();
	}
	
	public double sueldoBruto() {
		return sueldoBase + montoHExtras();
	}
	
	public double sueldoNeto() {
		return sueldoBruto() + montoDescuentos();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getArea() {
		return area;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public String getTipo_seg() {
		return tipo_seg;
	}
}
