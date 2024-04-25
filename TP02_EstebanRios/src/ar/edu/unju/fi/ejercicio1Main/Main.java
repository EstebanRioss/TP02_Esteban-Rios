package ar.edu.unju.fi.ejercicio1Main;

import ar.edu.unju.fi.ejercicio1Model.Producto;
import ar.edu.unju.fi.ejercicio1Model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1Model.Producto.OrigenFabricacion;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	private static Scanner sc;
	private static Scanner sc2;
	public static void main(String[] args) {
		List<Producto> listado = new ArrayList<Producto>();
		Scanner sc = new Scanner(System.in);
		int opcion;
	
		do {
		System.out.println("***Menu***");
		System.out.println("1 – Crear Producto");
		System.out.println("2 – Mostrar productos");
		System.out.println("3 – Modificar producto");
		System.out.println("4 – Salir");
		System.out.println("Ingrese Opcion: ");
		opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:{
				Producto prod = new Producto();
				prod = Opcion1();
				listado.add(prod);
				break;
			}
			case 2:{
				int p = 1;
				for(Producto i : listado) {
					System.out.println("Datos del producto " + p);
					Opcion2(i);
					p++;
				}
				break;
			}
			case 3:{
				System.out.println("Ingrese el codigo del producto a modificar");
				String codigo = sc.next();
				for(Producto i : listado){
					if(codigo.equals(i.getCodigo())) {
						i =Opcion3(i);
						break;
					}
				}
				break;
			}
			case 4:{
				System.out.println("Fin de Programa");
				break;
			}
			default:{
				System.out.println("Opcion no diponible");
				break;
			}
		}
		
		}while(opcion != 4);
		
		sc.close();
		
	}
	
	
	public static Producto Opcion1() {
		sc = new Scanner(System.in);
		Producto prod = new Producto();
		Boolean band = false;
		
		do {
			try {
				System.out.println("Ingrese el codigo: ");
				String codigo = sc.next();
				prod.setCodigo(codigo);
				band = true;
				
			}catch (Exception e) {
				System.out.println("Error en codigo");
			}
		}while(!band);
		band = false;
		
		do {
			try {
				System.out.println("Ingrese la descripcion: ");
				sc.nextLine();
				String Descripcion = sc.nextLine();
				prod.setDescripcion(Descripcion);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en descripcion");
			}
		}while(!band);
		band = false;
		
		do {
			try {
				System.out.println("Ingrese el precio: ");
				Double PrecioU = sc.nextDouble();
				prod.setPrecioU(PrecioU);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en Precio");
			}
		
		}while(!band);
		band = false;
		
		do {
			System.out.println("---- Origen de fabricación ------");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			System.out.println("Ingrese una opcion");
			int opcion = sc.nextInt();
			switch(opcion) {
				case 1:{
					prod.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
					band = true;
					break;
				}
				case 2:{
					prod.setOrigenFabricacion(OrigenFabricacion.CHINA);
					band = true;
					break;
				}
				case 3:{
					prod.setOrigenFabricacion(OrigenFabricacion.BRASIL);
					band = true;
					break;
				}
				case 4:{
					prod.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
					band = true;
					break;
				}
				default:{
					System.out.println("Fuera de Rango");
					break;
				}
			}
		}while(!band);
		band = false;
		
		do {
			System.out.println("---- Categoria ------");
			System.out.println("1 - Telefonia");
			System.out.println("2 - Informatica");
			System.out.println("3 - Electro Hogar");
			System.out.println("4 - Herramienta");
			System.out.println("Ingrese una opcion");
			int opcion = sc.nextInt();
			switch(opcion) {
				case 1:{
					prod.setCategoria(Categoria.TELEFONIA);
					band = true;
					break;
				}
				case 2:{
					prod.setCategoria(Categoria.INFORMATICA);
					band = true;
					break;
				}
				case 3:{
					prod.setCategoria(Categoria.ELECTROHOGAR);
					band = true;
					break;
				}
				case 4:{
					prod.setCategoria(Categoria.HERRAMIENTAS);
					band = true;
					break;
				}
				default:{
					System.out.println("Fuera de Rango");
					break;
				}
			}
		}while(!band);	
		
		return prod;
	}
	public static void Opcion2(Producto prod){
		System.out.println(prod.toString());
	}
	public static Producto Opcion3(Producto prod) {
		sc2 = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("***Modificador***");
			System.out.println("1 – Descripcion");
			System.out.println("2 – Precio");
			System.out.println("3 – Origen de fabricacion");
			System.out.println("4 - Categoria");
			System.out.println("5 - salir");
			System.out.println("Ingrese Opcion: ");
			opcion = sc2.nextInt();
			switch(opcion) {
				case 1:{
					Boolean band = false;
					
					do {
						try {
							System.out.println("Ingrese la descripcion: ");
							sc2.nextLine();
							String descripcion = sc2.nextLine();
							prod.setDescripcion(descripcion);
							band = true;
						}catch (Exception e) {
							System.out.println("Error en descripcion");
						}
					}while(!band);
					band = false;
					
					break;
				}
				case 2:{
					Boolean band = false;
					
					do {
						try {
							System.out.println("Ingrese el precio: ");
							sc2.nextLine();
							Double precio = sc2.nextDouble();
							prod.setPrecioU(precio);
							band = true;
						}catch (Exception e) {
							System.out.println("Error en precio");
						}
					}while(!band);
					band = false;
					
					break;
				}
				case 3:{
					Boolean band = false;
					
					do {
						try {
							System.out.println("---- Origen de fabricación ------");
							System.out.println("1 - Argentina");
							System.out.println("2 - China");
							System.out.println("3 - Brasil");
							System.out.println("4 - Uruguay");
							System.out.println("Ingrese una opcion");
							int op = sc2.nextInt();
							switch(op) {
								case 1:{
									prod.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
									band = true;
									break;
								}
								case 2:{
									prod.setOrigenFabricacion(OrigenFabricacion.CHINA);
									band = true;
									break;
								}
								case 3:{
									prod.setOrigenFabricacion(OrigenFabricacion.BRASIL);
									band = true;
									break;
								}
								case 4:{
									prod.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
									band = true;
									break;
								}
								default:{
									System.out.println("Fuera de Rango");
									break;
								}
							}

						}catch (Exception e) {
							System.out.println("Error en codigo");
						}
					}while(!band);
					band = false;
					
					break;
				}
				case 4:{
					Boolean band = false;
					do {
						try {
							System.out.println("---- Categoria ------");
							System.out.println("1 - Telefonia");
							System.out.println("2 - Informatica");
							System.out.println("3 - Electro Hogar");
							System.out.println("4 - Herramienta");
							System.out.println("Ingrese una opcion");
							int op = sc2.nextInt();
							switch(op) {
								case 1:{
									prod.setCategoria(Categoria.TELEFONIA);
									band = true;
									break;
								}
								case 2:{
									prod.setCategoria(Categoria.INFORMATICA);
									band = true;
									break;
								}
								case 3:{
									prod.setCategoria(Categoria.ELECTROHOGAR);
									band = true;
									break;
								}
								case 4:{
									prod.setCategoria(Categoria.HERRAMIENTAS);
									band = true;
									break;
								}
								default:{
									System.out.println("Fuera de Rango");
									break;
								}
							}
						}catch (Exception e) {
							System.out.println("Error en codigo");
						}
					}while(!band);
					break;
				}
				case 5:{
					break;
				}

				default:{
					System.out.println("Fuera de rango");
					break;
				}
			}
		}while(opcion != 5);
		return prod;
	}

}



	
		
	
