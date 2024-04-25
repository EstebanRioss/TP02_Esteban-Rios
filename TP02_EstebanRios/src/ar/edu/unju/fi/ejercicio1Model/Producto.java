package ar.edu.unju.fi.ejercicio1Model;

public class Producto {
	private String Codigo;
	private String Descripcion;
	private double PrecioU;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;

	
	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
		PrecioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	public Producto() {
		
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getPrecioU() {
		return PrecioU;
	}
	public void setPrecioU(double precioU) {
		PrecioU = precioU;
	}
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Codigo del producto es: " + Codigo + "\nDescripcion del producto: " + Descripcion + "\nPrecio del producto: " + PrecioU
				+ "\nOrigen de fabricacion: " + origenFabricacion + "\nCategoria: " + categoria;
	}
	
	
}
