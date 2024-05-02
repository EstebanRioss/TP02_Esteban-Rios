package ar.edu.unju.fi.ejercicio5Model;

public class Producto {
	private String Codigo;
	private String Descripcion;
	private Double PrecioU;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
    public Boolean Estado;
    
    public Producto(String codigo, String descripcion, Double precioU, OrigenFabricacion origenFabricacion,
			Categoria categoria, Boolean estado) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
		PrecioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		Estado = estado;
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
	public Double getPrecioU() {
		return PrecioU;
	}
	public void setPrecioU(Double precioU) {
		PrecioU = precioU;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
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