package ar.edu.unju.fi.ejercicio5Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5Model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5Model.*;
import ar.edu.unju.fi.ejercicio5Model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List <Producto> Productos = new ArrayList<Producto>();
		List <Producto> ProductosDisponibles = new ArrayList<Producto>();
		Productos = Precarga(Productos);
		int opcion = 0;
		Double Monto = (double) 0;
		ProductosDisponibles = Disponible(Productos);
		
		do {
			System.out.println("***MENU***");
			System.out.println("Monto: " + Monto);
			System.out.println("1 - Mostrar productos");
			System.out.println("2 - Realizar pago");
			System.out.println("3 - salir");
			System.out.println("Ingrese una opcion: ");
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:{
				try {
					MostrarProductos(ProductosDisponibles);
					System.out.println("Ingrese el codigo de un producto: ");
					String codigo = sc.next();
					Monto = AgregarMonto(codigo,ProductosDisponibles,Monto);
					
				}catch (Exception e) {
					System.out.println("Error");
				}
				
				break;
			}
			case 2:{
				int op = 0;
				System.out.println("Con que metodo desea pagar: ");
				System.out.println("1 - Tarjeta de credito (+15%)");
				System.out.println("2 - Efectivo (-10%)");
				System.out.println("Ingrese una opcion: ");
				op = sc.nextInt();
				switch(op) {
				case 1:{
					PagarconTarjeta(Monto,sc);
					break;
				}
				case 2:{
					Pagarconefectivo(Monto);
					break;
				}
				default:{
					System.out.println("Fuera de Rango");
					break;
				}
				}
				Monto = (double) 0;
				break;
			}
			case 3:{
				System.out.println("Fin de programa");
				break;
			}
			default:{
				System.out.println("Fuera de rango");
				break;
			}
			}
		}while (opcion != 3);
		sc.close();
	}
	
	static void Pagarconefectivo(Double Monto) {
		PagoEfectivo Efectivo = new PagoEfectivo();
		Efectivo.setMontoPagado(Monto);
		Efectivo.setFechaPago(LocalDate.now());
		
		Efectivo.RealizarPago(Monto);
		Efectivo.ImprimirRecibo();
	}
	
	static void PagarconTarjeta(Double Monto , Scanner sc) { 
	    PagoTarjeta Tarjeta = new PagoTarjeta();
	    
	    System.out.println("Ingrese el numero de la tarjeta: ");
	    String Numero = sc.nextLine();
	    Tarjeta.setNumeroTarjeta(Numero);
	    Tarjeta.setMontoPagado(Monto);
	    Tarjeta.setFechaPago(LocalDate.now());
	    
	    Tarjeta.RealizarPago(Monto);
	    Tarjeta.ImprimirRecibo();

	}
	
	static List <Producto> Disponible(List <Producto> Productos) {
		List <Producto> D = new ArrayList<Producto>();
		for(Producto p : Productos) {
			if(p.getEstado()) {
				D.add(p);
			}
		}
		return D;
	}
	
	static Double AgregarMonto(String codigo , List <Producto> Productos, Double Monto){
		
		for(Producto p : Productos) {
			if(p.getCodigo().equals(codigo)) {
				Monto += p.getPrecioU();
			}
		}
		
		return Monto;
	}
	
	static void MostrarProductos(List <Producto> Productos) {
		int  i = 1;
		for (Producto p : Productos) {
				System.out.println("Producto N " + i );
				System.out.println(p.toString());
				System.out.println();
				
				i++;
		}
	}
	static List <Producto> Precarga(List <Producto> Productos){
		
		Productos.add(new Producto("01", "Cable Ethernet",1500.0, OrigenFabricacion.BRASIL , Categoria.INFORMATICA , true));
		Productos.add(new Producto("02", "Licuadora",5000.0, OrigenFabricacion.CHINA , Categoria.HERRAMIENTAS , false));
		Productos.add(new Producto("03", "Taladro",6000.0, OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS , true));
		Productos.add(new Producto("04", "Notebook",64000.0, OrigenFabricacion.CHINA , Categoria.INFORMATICA , true));
		Productos.add(new Producto("05", "Celular Xiaomi",24000.0, OrigenFabricacion.CHINA , Categoria.TELEFONIA , true));
		Productos.add(new Producto("06", "Aspiradora",12500.0, OrigenFabricacion.CHINA , Categoria.ELECTROHOGAR , false));
		Productos.add(new Producto("07", "Sierra Circular",10500.0, OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS , true));
		Productos.add(new Producto("08", "Computadora de escritorio",56000.0, OrigenFabricacion.CHINA , Categoria.INFORMATICA , true));
		Productos.add(new Producto("09", "Teléfono móvil Samsung",30000.0, OrigenFabricacion.BRASIL , Categoria.TELEFONIA , true));
		Productos.add(new Producto("10", "Hervidor eléctrico",3000.0, OrigenFabricacion.CHINA , Categoria.INFORMATICA , false));
		Productos.add(new Producto("11", "Destornillador eléctrico",4500.0, OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS , true));
		Productos.add(new Producto("12", "Monitor LG",20000.0, OrigenFabricacion.CHINA , Categoria.INFORMATICA , true));
		Productos.add(new Producto("13", "Auriculares Bluetooth",3500.0, OrigenFabricacion.CHINA , Categoria.TELEFONIA , false));
		Productos.add(new Producto("14", "Plancha de vapor",2500.0, OrigenFabricacion.CHINA , Categoria.ELECTROHOGAR , true));
		Productos.add(new Producto("15", "Taladro percutor ",7000.0, OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS , true));
		Productos.add(new Producto("16", "Tableta gráfica",12000.0, OrigenFabricacion.CHINA , Categoria.INFORMATICA , false));
		
		return Productos;
	}
	
}
