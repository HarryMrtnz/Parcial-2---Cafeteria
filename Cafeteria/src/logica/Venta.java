package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Venta {
	private int id;
	private Cafe cafe;
	private int cantidad;
	private boolean tarjetaSocio;
	private double total;

	public Venta(int id, Cafe cafe, int cantidad, boolean tarjetaSocio, double total) {
		super();
		this.id = id;
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.tarjetaSocio = tarjetaSocio;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public static void mostrarVentas(LinkedList<Venta> ventas) {
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {
			for (Venta venta : ventas) {
				JOptionPane.showMessageDialog(null,
						"Venta Numero: " + venta.getId() + "\n Productos: " + venta.getCafe().getTipo() + " [Precio: $"
								+ venta.getCafe().getPrecio() + "] x" + venta.getCantidad() + "\n Descuento "
								+ venta.isTarjetaSocio() + "\n Total: $" + venta.getTotal() + "\n");
			}
		}
	}

	public static void mostrarVentasConDescuento(LinkedList<Venta> ventas) {
		for (Venta venta : ventas) {
			if (venta.isTarjetaSocio()) {
				JOptionPane.showMessageDialog(null,
						"Venta Numero: " + venta.getId() + "\n Productos: " + venta.getCafe().getTipo() + " [Precio: $"
								+ venta.getCafe().getPrecio() + "] x" + venta.getCantidad() + "\n Descuento "
								+ venta.isTarjetaSocio() + "\n Total: $" + venta.getTotal() + "\n");
			}
		}
	}

	public static String cafeMasVendido(LinkedList<Venta> ventas) {
		int latte = 0, flat_white = 0, lagrima = 0, expresso = 0;
		String masVendido = "";
		for (Venta venta : ventas) {
			if (venta.getCafe().getTipo().equals("Latte")) {
				latte++;
			}

			if (venta.getCafe().getTipo().equals("Flat White")) {
				flat_white++;
			}

			if (venta.getCafe().getTipo().equals("Lagrima")) {
				lagrima++;
			}

			if (venta.getCafe().getTipo().equals("Expresso")) {
				expresso++;
			}
		}

		if (latte > flat_white && latte > lagrima && latte > expresso) {
			masVendido = " El cafe mas vendido es Latte con " + latte + " ventas.";

		} else if (flat_white > lagrima && flat_white >= expresso && flat_white > latte) {
			masVendido = " El cafe mas vendido es Flat White con " + flat_white + " ventas.";

		} else if (lagrima > flat_white && lagrima > expresso && lagrima > latte) {
			masVendido = " El cafe mas vendido es Lagrima con " + lagrima + " ventas.";

		} else if (expresso > flat_white && expresso > lagrima && expresso > latte) {
			masVendido = " El cafe mas vendido es Expresso con " + expresso + " ventas.";
		}
		return masVendido;

	}

	public static void eliminarVenta(LinkedList<Venta> ventas) {
		int opcion;
		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de venta a eliminar:"));
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {

			for (Venta venta : ventas) {
				if (venta.getId() == opcion) {
					ventas.remove(ventas.indexOf(venta));
					JOptionPane.showMessageDialog(null, "Se ha eliminado la venta numero " + opcion);
				}
			}
		}
	}

	public static void recaudacion(LinkedList<Venta> ventas) {
		double recaudacion = 0;

		for (Venta venta : ventas) {
			recaudacion = venta.getTotal() + recaudacion;

		}

		JOptionPane.showMessageDialog(null, "Se han hecho " + ventas.size() + " ventas hoy."
				+ "\n RECAUDACION TOTAL DEL DIA:" + "\n   $" + recaudacion);

	}

}
