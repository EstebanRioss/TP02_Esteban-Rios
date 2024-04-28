package ar.edu.unju.fi.ejercicio4Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4Constantes.Constantes.Posicion;
import ar.edu.unju.fi.ejercicio4model.Jugador;

public class Main {

	private static Scanner sc;
	public static void main(String[] args) {
		ArrayList<Jugador> Jugadores = new ArrayList<Jugador>();
		Scanner sc = new Scanner (System.in);
		int Opcion = 0;
		do {
			System.out.println("***Menu***");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 - Mostrar Datos del jugador");
			System.out.println("3 - Modificar la posición de un jugador");
			System.out.println("4 - Eliminar un jugador");
			System.out.println("5 - Salir");
			System.out.println("Ingrese una opcion: ");
			
			Opcion = sc.nextInt();
			switch(Opcion) {
				case 1:{
					Jugador jugador = new Jugador();
					jugador = opcion1(jugador);
					Jugadores.add(jugador);
					break;
				}
				case 2:{
					for(Jugador f : Jugadores) {
					opcion2(f);
					}
					break;
				}
				case 3:{
					Boolean band = false;
					try {
						System.out.println("Ingrese el nombre : ");
						String nombre = sc.next();
						System.out.println("Ingrese el apellido: ");
						String apellido = sc.next();
						for(Jugador jugador : Jugadores) {
							if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)){
								System.out.println("Posicion");
								do {
									
										System.out.println("1 - DELANTERO ");
										System.out.println("2 - MEDIO");
										System.out.println("3 - DEFENSA");
										System.out.println("4 - ARQUERO");
										int op = sc.nextInt();
										switch(op) {
											case 1:{
												jugador.setPosicion(Posicion.DELANTERO);
												band  = true;
												break;
											}
											case 2:{
												jugador.setPosicion(Posicion.MEDIO);
												band  = true;
												break;
											}
											case 3:{
												jugador.setPosicion(Posicion.DEFENSA);
												band  = true;
												break;
											}
											case 4:{
												jugador.setPosicion(Posicion.ARQUERO);
												band  = true;
												break;
											}
											default:{
												System.out.println("fuera de rango ");
												break;
											}
										}
								}while(band != true);
							}
						}
					}catch (Exception e) {
						System.out.println("Error en el ingreso de datos");
					}
					break;
				}
				case 4:{
						System.out.println("Ingrese el nombre : ");
						String nombre = sc.next();
						System.out.println("Ingrese el apellido: ");
						String apellido = sc.next();
						
						Iterator<Jugador> iterador = Jugadores.iterator();
				        while (iterador.hasNext()) {
				            Jugador jugador = iterador.next();
				            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
				                iterador.remove();
				                break;
				            }
				        }
						
					break;
				}
			}
			
		}while(Opcion != 5);
		sc.close();
	}
	public static Jugador opcion1(Jugador jugador) {
		sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Boolean band = false;
		LocalDate FechaNac = null;
		
		System.out.println("**Ingrese los datos del  jugador**");
		do{
			try {
				System.out.println("Nombre: ");
				String Nombre = sc.next();
				jugador.setNombre(Nombre);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
			}
		}while(!band);
		band  = false;
		
		System.out.println("Apellido: ");
		do {
			try {
				String Apellido = sc.next();
				jugador.setApellido(Apellido);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
			}
		}while(!band);
		band  = false;
		
		System.out.println("Fecha de Nacimiento (yyyy-MM-dd): ");
		do{
			String Fecha = sc.next();
			try {
				FechaNac = LocalDate.parse(Fecha, formatter);
				jugador.setFechaNac(FechaNac);
				band = true;
			}catch (Exception e) {
				System.out.println("La fecha ingresada no es válida. Asegúrate de que esté en el formato correcto (yyyy-MM-dd).");
				System.out.println("Ingrese otra vez: ");
			}
		}while(band != true);
		band = false;
		
		
		System.out.println("Nacionalidad: ");
		do {
			try {
				String Nacionalidad = sc.next();
				jugador.setNacionalidad(Nacionalidad);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
			}
		}while(!band);
		band  = false;
		
		System.out.println("Estatura (metros con ,): ");
		do{
			try {
				float estatura = sc.nextFloat();
				jugador.setEstatura(estatura);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
				sc.nextLine();
			}
		}while(band != true);
		band = false;
		
		System.out.println("Peso (kg con ,): ");
		do{
			try {
				float peso = sc.nextFloat();
				jugador.setPeso(peso);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
				sc.nextLine();
			}
		}while(band != true);
		band = false;
		
		System.out.println("Posicion ");
		do {
			try {
				System.out.println("1 - DELANTERO ");
				System.out.println("2 - MEDIO");
				System.out.println("3 - DEFENSA");
				System.out.println("4 - ARQUERO");
				int op = sc.nextInt();
				switch(op) {
					case 1:{
						jugador.setPosicion(Posicion.DELANTERO);
						band  = true;
						break;
					}
					case 2:{
						jugador.setPosicion(Posicion.MEDIO);
						band  = true;
						break;
					}
					case 3:{
						jugador.setPosicion(Posicion.DEFENSA);
						band  = true;
						break;
					}
					case 4:{
						jugador.setPosicion(Posicion.ARQUERO);
						band  = true;
						break;
					}
					default:{
						System.out.println("fuera de rango ");
						break;
					}
				}
				
			}catch(Exception e) {
				System.out.println("Error en el ingreso de datos");
				System.out.println("Ingrese otra vez: ");
			}
		}while(band != true);
		
		return jugador;
	}
	public static void opcion2(Jugador j){
		j.MostrarDatos();
	}
	
}
