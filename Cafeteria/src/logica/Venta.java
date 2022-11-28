package logica;

public class Venta {
	private String id;
	private Cafe cafe;
	private int cantidad;
	private boolean tarjetaSocio;
	private double total;

	public Venta(String id, Cafe cafe, int cantidad, boolean tarjetaSocio, double total) {
		super();
		this.id = id;
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.tarjetaSocio = tarjetaSocio;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isTarjetaSocio() {
		return tarjetaSocio;
	}

	public void setTarjetaSocio(boolean tarjetaSocio) {
		this.tarjetaSocio = tarjetaSocio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", cafe=" + cafe + ", cantidad=" + cantidad + ", tarjetaSocio=" + tarjetaSocio
				+ ", total=" + total + "]";
	}

	public double venta (double precio, double total) {
		
		this.total = this.getCafe().getPrecio() * this.getCantidad();
		
		return total;
	}
	
	 
	
	
	
	
	
}
