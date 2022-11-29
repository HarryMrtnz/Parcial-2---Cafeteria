package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Cafe;
import logica.Venta;

public class Main {

	public static void main(String[] args) {
		
		LinkedList <Venta> ventas = new LinkedList(); 
		
		//hardcodeando ventas (Entregar con los objetos comentados).
//		Cafe latte = new Cafe ("Latte", 1.50);
//		Cafe flat_white = new Cafe ("Flat White", 2.50);
//		Cafe lagrima = new Cafe ("Lagrima", 1.30);
//		Cafe expresso = new Cafe ("Expresso", 1.00);
//		
//		ventas.add(new Venta(1, expresso, 3, false, 3.0));
//		ventas.add(new Venta(2, latte, 1, false, 6.0));
//		ventas.add(new Venta(3, lagrima, 5, false, 5.525));
//		ventas.add(new Venta(4, flat_white, 2, true, 4.25));
//		ventas.add(new Venta(5, lagrima, 6, true, 2.21));
		
//		JOptionPane.showInputDialog(null,"Bienvenido.\n Elije el cafe que desea llevar:",JOptionPane.DEFAULT_OPTION);
		
		menu(ventas);
			
		
	}
	
	public static void menu(LinkedList<Venta>ventas) {
		
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
					menu(ventas);
				default:
					menu(ventas);
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
						menu(ventas);
						break;
					}
			}		
			break;
		case 2:
			venta.mostrarVentas(ventas);
			menu(ventas);
			break;
		case 3:
			JOptionPane.showMessageDialog(null,venta.cafeMasVendido(ventas));
			menu(ventas);
			break;
		case 4:
			venta.recaudacion(ventas);
			menu(ventas);
			break;
		case 5:
			venta.mostrarVentasConDescuento(ventas);
			menu(ventas);
			break;
		case 6:
			venta.eliminarVenta(ventas);
			menu(ventas);
			break;
		default:
			menu(ventas);
			break;
		}
		
	}
	
//	public static void recaudacion(LinkedList<Venta> ventas) {
//		double recaudacion = 0;
//		
//		for (Venta venta : ventas) {
//			recaudacion = venta.getTotal()+ recaudacion;
//			
//		}
//		
//		JOptionPane.showMessageDialog(null,"Se han hecho "+ventas.size()+" ventas hoy."  
//				+"\n RECAUDACION TOTAL DEL DIA:" 
//				+"\n   $"+recaudacion);
//		
//	}
	
	
}
