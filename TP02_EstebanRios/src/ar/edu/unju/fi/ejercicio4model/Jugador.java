package ar.edu.unju.fi.ejercicio4model;

import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio4Constantes.Constantes.Posicion;

public class Jugador {
	private String Nombre;
	private String Apellido;
	private LocalDate FechaNac;
	private String Nacionalidad;
	private float Estatura;
	private float Peso;
	private Posicion Posicion;
	
	public Jugador() {
		
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public LocalDate getFechaNac() {
		return FechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		FechaNac = fechaNac;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public float getEstatura() {
		return Estatura;
	}
	public void setEstatura(float estatura) {
		Estatura = estatura;
	}
	public float getPeso() {
		return Peso;
	}
	public void setPeso(float peso) {
		Peso = peso;
	}
	public Posicion getPosicion() {
		return Posicion;
	}
	public void setPosicion(Posicion posicion) {
		Posicion = posicion;
	}
	public void MostrarDatos() {
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Apellido: " + this.getApellido());
		System.out.println("Fecha de nacimiento: " + this.getFechaNac());
		System.out.println("Nacionalidad: " + this.getNacionalidad());
		System.out.println("Estatura: " + this.getEstatura());
		System.out.println("Peso: " + this.getPeso());
		System.out.println("Posicion: " + this.getPosicion());
	}
	
	
}
