package ar.edu.unju.fi.ejercicio7Main;

import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

import ar.edu.unju.fi.ejercicio5Model.Producto;
import ar.edu.unju.fi.ejercicio5Model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5Model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		List<Producto> Productos = new ArrayList<Producto>();
		Productos = Precarga(Productos);
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		
		do {
			System.out.println("***MENU***");
			System.out.println("1 - Mostrar Productos");
			System.out.println("2 - Mostrar los productos faltantes");
			System.out.println("3 - Incrementar los precios de los productos en un 20%");
			System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
			System.out.println("5 - Ordenar los productos por precio de forma descendente.");
			System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
			System.out.println("7 - salir");
			System.out.println("Ingrese una opcion: ");
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:{
					Disponible(Productos);
					break;
				}
				case 2:{
					NoDisponible(Productos);
					break;
				}
				case 3:{
					Productos = IncrementarPrecios(Productos);
					break;
				}
				case 4:{
					CategoriaDisponible(Productos);
					break;
				}
				case 5:{
					OrdenadoDescendiente(Productos);
					break;
				}
				case 6:{
					ProductosMayus(Productos);
					break;
				}
				default:{
					System.out.println("Opcion fuera de rango ");
					break;
				}
			}
		}while(opcion != 7);
		
		sc.close();
	}
	
	static void ProductosMayus(List <Producto> Productos){
		Function<Producto, Producto> Mayus = producto -> {
			String DesMayusculas = producto.getDescripcion().toUpperCase();
			producto.setDescripcion(DesMayusculas);
			return producto;
		};
		List<Producto> productosMayusculas = Productos.stream().map(Mayus).collect(Collectors.toList());
		
		productosMayusculas.forEach(producto -> {
		    System.out.println("Producto con código: " + producto.getCodigo());
		    System.out.println("Nombre/descripcion en mayúsculas: " + producto.getDescripcion());
		});
		
	}
	
	static void OrdenadoDescendiente(List <Producto> Productos) {
		Comparator<Producto> Comparador = Comparator.comparing(Producto :: getPrecioU).reversed();
		
		Productos.sort(Comparador);
		
		Productos.forEach(producto -> {
		    System.out.println("Producto con código: " + producto.getCodigo());
		    System.out.println(producto);
		});

	}
	
	static void CategoriaDisponible(List <Producto> Productos) {
		Predicate<Producto> NoDisponibles = (Producto) -> Producto.Estado && Producto.getCategoria().equals(Categoria.ELECTROHOGAR);
		List<Producto> ProductosNoDisponibles = Productos.stream().filter(NoDisponibles).collect(Collectors.toList());
		
		
		ProductosNoDisponibles.forEach(Producto-> {
			System.out.println("Producto con código: " + Producto.getCodigo());
		    System.out.println(Producto);
		});
	}
	
	static List <Producto> IncrementarPrecios(List <Producto> Productos){
		Function<Producto, Producto> Incremento = producto -> {
			Double PrecioI = producto.getPrecioU()*1.20;
			producto.setPrecioU(PrecioI);
			return producto;
		};
		List<Producto> ProductosI = Productos.stream().map(Incremento).collect(Collectors.toCollection(ArrayList :: new));
		return ProductosI;
		
	}
	
	static void NoDisponible(List <Producto> Productos) {
		Predicate<Producto> NoDisponibles = (Producto) -> !Producto.Estado;
		List<Producto> ProductosNoDisponibles = Productos.stream()
														.filter(NoDisponibles)
														.collect(Collectors.toList());
		ProductosNoDisponibles.forEach(Producto-> {
			System.out.println("Producto con código: " + Producto.getCodigo());
		    System.out.println(Producto);
		});
	}

	static void Disponible(List <Producto> Productos) {
		Consumer<Producto> disponible = (Producto) -> {
			if(Producto.getEstado()) {
				System.out.println("Producto con codigo: " + Producto.getCodigo());
				System.out.println(Producto);
			}
		};
		Productos.forEach(disponible);
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
