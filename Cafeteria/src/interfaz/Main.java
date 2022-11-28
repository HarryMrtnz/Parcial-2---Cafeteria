package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Cafe;
import logica.Venta;

public class Main {

	public static void main(String[] args) {
		
		Cafe latte = new Cafe ("Late", 1.50);
		Cafe flat_white = new Cafe ("Flat White", 2.50);
		Cafe lagrima = new Cafe ("Lagrima", 1.30);
		Cafe expresso = new Cafe ("Expresso", 1.00);
		
		LinkedList <Venta> ventas = new LinkedList(); 
		LinkedList <Venta> ventasConDescuento = new LinkedList(); 
		LinkedList <Cafe> listaCafe = new LinkedList(); 
		
		listaCafe.add(latte);
		listaCafe.add(flat_white);
		listaCafe.add(lagrima);
		listaCafe.add(expresso);
		
//		JOptionPane.showInputDialog(null,"Bienvenido.\n Elije el cafe que desea llevar:",JOptionPane.DEFAULT_OPTION);
		JOptionPane.showInputDialog(null,"Bienvenido.\n Elije el cafe que desea llevar:",JOptionPane.QUESTION_MESSAGE);
		
		
		
		
	}

	public static void mostrarVentas(LinkedList<Venta> ventas) {
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {
			for (Venta venta : ventas) {
				System.out.println("Venta Numero: "+venta.getId() 
									+"\n Productos: "+venta.getCafe()
									+" x"+ venta.getCantidad()
									+"\n Total: "+venta.getTotal());
			}
		}
	}
	
	public static void mostrarVentasConDescuento(LinkedList<Venta> ventasconDescuento) {
		if (ventasconDescuento.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {
			for (Venta venta : ventasconDescuento) {
				System.out.println("Venta Numero: "+venta.getId() 
									+"\n Productos: "+venta.getCafe()
									+" x"+ venta.getCantidad()
									+"\n Total: "+venta.getTotal());
			}
		}
	}
	
	public static void recaudacion() {
		
	}
	
	
	
	
}
