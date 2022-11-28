package logica;

public class Cafe {
	private String tipo;
	private double precio;
	
	public Cafe(String tipo, double precio) {
		super();
		this.tipo = tipo;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Cafe [tipo=" + tipo + ", precio=" + precio + "]";
	}
	

	
	
}
