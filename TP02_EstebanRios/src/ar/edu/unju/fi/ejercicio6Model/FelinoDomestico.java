package ar.edu.unju.fi.ejercicio6Model;

public class FelinoDomestico {
	private String Nombre;
	private Byte Edad;
	private Float Peso;

	public FelinoDomestico(String nombre, Byte edad, Float peso) {
		super();
		Nombre = nombre;
		Edad = edad;
		Peso = peso;
	}
	
	public FelinoDomestico() {
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Byte getEdad() {
		return Edad;
	}

	public void setEdad(Byte edad) {
		Edad = edad;
	}

	public Float getPeso() {
		return Peso;
	}

	public void setPeso(Float peso) {
		Peso = peso;
	}
	
	@Override
	public String toString() {
		return "FelinoDomestico [Nombre=" + Nombre + ", Edad=" + Edad + ", Peso=" + Peso + "]";
	}
	
}
