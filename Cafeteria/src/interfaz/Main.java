package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Cafe;
import logica.Venta;

public class Main {

	public static void main(String[] args) {
		
		LinkedList <Venta> ventas = new LinkedList(); 
		LinkedList <Venta> ventasConDescuento = new LinkedList(); 
		LinkedList <Cafe> listaCafe = new LinkedList(); 
		
		
//		Cafe latte = new Cafe ("Late", 1.50);
//		Cafe flat_white = new Cafe ("Flat White", 2.50);
//		Cafe lagrima = new Cafe ("Lagrima", 1.30);
//		Cafe expresso = new Cafe ("Expresso", 1.00);
//		
//		ventas.add(new Venta(1, expresso, 3, false, 5));
//		ventas.add(new Venta(2, latte, 1, false, 4));
//		ventas.add(new Venta(3, lagrima, 5, true, 2));
//		ventas.add(new Venta(4, flat_white, 2, true, 8));
		
//		JOptionPane.showInputDialog(null,"Bienvenido.\n Elije el cafe que desea llevar:",JOptionPane.DEFAULT_OPTION);
		menu(ventas, ventasConDescuento);
			
		
	}
	
	public static void menu(LinkedList<Venta>ventas, LinkedList<Venta>ventasConDescuento) {
		
		Venta venta = null;
		int opcion;
		opcion =  Integer.parseInt(JOptionPane.showInputDialog(null,"Bienvenido.\nElije que opcion deseada:\n"
				+ " 1 - Realizar venta\n"
				+ " 2 - Mostrar todas las ventas\n"
				+ " 3 - Ver caffe mas vendido\n"
				+ " 4 - Recuadacion total\n"
				+ " 5 - Ver ventas con descuento\n"
				+ " 6 - Eliminar venta\n"));
		
		switch (opcion) {
		case 1:
			int id=1;
			
			while (opcion != 0) {

				String caffe;
				int cant;
				double precio = 0.0, total = 0.0;
				int desc;
				boolean descuento = true;
	
				caffe = JOptionPane.showInputDialog(null,"VENTAS.\nElije el cafe que desea llevar:\n"
						+ " A - Latte\n"
						+ " B - Flat White\n"
						+ " C - Lagrima\n"
						+ " D - Expresso\n"
						+ "\n X - Cerrar caja\n");
				
				switch (caffe) {
				case "a":
					Cafe latte = new Cafe ("Latte", 1.50);
					venta = new Venta(id, latte, 0, false, 0);
					break;
				case "b":
					Cafe flat_white = new Cafe ("Flat White", 2.50);
					venta = new Venta(id, flat_white, 0, false, 0);
					break;
				case "c":
					Cafe lagrima = new Cafe ("Lagrima", 1.30);
					venta = new Venta(id, lagrima, 0, false, 0);
					break;
				case "d":
					Cafe expresso = new Cafe ("Expresso", 1.00);
					venta = new Venta(id, expresso, 0, false, 0);
					break;
				case "x":
					menu(ventas, ventasConDescuento);
				default:
					menu(ventas, ventasConDescuento);
					break;
				}
			
				cant = Integer.parseInt(JOptionPane.showInputDialog(null,"CANTIDAD.\n Cantidad que desea llevar?"));
				
				switch (caffe) {
				case "a":
					precio = cant*1.50;
					break;
				case "b":
					precio = cant*2.50;
					break;
				case "c":
					precio = cant*1.30;
					break;
				case "d":
					precio = cant*1.00;
					break;
	
				default:
					break;
				}
			
				desc = JOptionPane.showConfirmDialog(null, "¿Tiene tarjeta de descuento?");
				
					if (desc == JOptionPane.YES_OPTION ) {
						descuento = (true);
						total = precio * 0.85;
					} else if (desc == JOptionPane.NO_OPTION){
						descuento = (false);
						total = precio;
					}
					switch (caffe) {
					case "a":
						venta.setId(id++); venta.setCantidad(cant); venta.setTarjetaSocio(descuento); venta.setTotal(total);
						ventas.add(venta);
						break;
					case "b":
						venta.setId(id++); venta.setCantidad(cant); venta.setTarjetaSocio(descuento); venta.setTotal(total);
						ventas.add(venta);
						break;
					case "c":
						venta.setId(id++); venta.setCantidad(cant); venta.setTarjetaSocio(descuento); venta.setTotal(total);
						ventas.add(venta);
						break;
					case "d":
						venta.setId(id++); venta.setCantidad(cant); venta.setTarjetaSocio(descuento); venta.setTotal(total);
						ventas.add(venta);
						break;
	
					default:
						break;
					}
			}		
			break;
		case 2:
			mostrarVentas(ventas);
			menu(ventas, ventasConDescuento);
			break;
		case 3:
			
			break;
		case 4:
			recaudacion(ventas);
			menu(ventas, ventasConDescuento);
			break;
		case 5:
			mostrarVentasConDescuento(ventas, ventasConDescuento);
			menu(ventas, ventasConDescuento);
			break;
		case 6:
			eliminarVenta(ventas);
			menu(ventas, ventasConDescuento);
			break;
		default:
			menu(ventas, ventasConDescuento);
			break;
		}
		
	}
	



	public static void mostrarVentas(LinkedList<Venta> ventas) {
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {
			for (Venta venta : ventas) {
				JOptionPane.showMessageDialog(null, "Venta Numero: "+venta.getId() 
				+"\n Productos: "+venta.getCafe().getTipo()
				+" [Precio: $"+venta.getCafe().getPrecio()
				+"] x"+ venta.getCantidad()
				+"\n Descuento "+ venta.isTarjetaSocio()
				+"\n Total: $"+venta.getTotal()+"\n");
			}
		}
	}
	
	public static void mostrarVentasConDescuento(LinkedList<Venta> ventas, LinkedList<Venta> ventasconDescuento) {
		for (Venta venta : ventas) {
			if (venta.isTarjetaSocio()) {
				ventasconDescuento.add(venta);
				
			}
			for (Venta venta2 : ventasconDescuento) {
				
			
				JOptionPane.showMessageDialog(null, "Venta Numero: "+venta2.getId() 
				+"\n Productos: "+venta2.getCafe().getTipo()
				+" [Precio: $"+venta2.getCafe().getPrecio()
				+"] x"+ venta2.getCantidad()
				+"\n Descuento "+ venta2.isTarjetaSocio()
				+"\n Total: $"+venta2.getTotal()+"\n");
			}
		}
	}
	
	public static void recaudacion(LinkedList<Venta> ventas) {
		double recaudacion = 0;
		
		for (Venta venta : ventas) {
			recaudacion = venta.getTotal()+ recaudacion;
			
		}
		
		JOptionPane.showMessageDialog(null,"Se han hecho "+ventas.size()+" ventas hoy."  
				+"\n RECAUDACION TOTAL DEL DIA:" 
				+"\n   $"+recaudacion);
		
	}
	
	public static void eliminarVenta(LinkedList<Venta> ventas) {
		int opcion;
		opcion =  Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de venta a eliminar:"));
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas pa!");
		} else {
			
			for (Venta venta : ventas) {
				if (venta.getId()== opcion) {
					ventas.remove(ventas.indexOf(venta));
					JOptionPane.showMessageDialog(null, "Se ha eliminado la venta numero "+opcion);
				}
			}
		}
	}
	
	
}
