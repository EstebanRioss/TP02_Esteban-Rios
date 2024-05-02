package ar.edu.unju.fi.ejercicio5Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5intefaces.Pago;

public class PagoTarjeta implements Pago{
	private String NumeroTarjeta;
	private LocalDate FechaPago;
	private Double MontoPagado;
	
	@Override
	public void RealizarPago(double monto) {
		this.MontoPagado = monto * 1.15;
	}
	
	@Override
	public void ImprimirRecibo() {
		System.out.println(" RECIBO	");
		System.out.println("Numero de tarjeta: " + this.NumeroTarjeta);
		System.out.println("Fecha de pago: " + this.FechaFormateada(this.FechaPago));
		System.out.println("Monto pagado: " + this.MontoPagado);
		
	}
	
	public String getNumeroTarjeta() {
		return NumeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		NumeroTarjeta = numeroTarjeta;
	}
	public LocalDate getFechaPago() {
		return FechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		FechaPago = fechaPago;
	}
	public Double getMontoPagado() {
		return MontoPagado;
	}
	public void setMontoPagado(Double montoPagado) {
		MontoPagado = montoPagado;
	}
	public String FechaFormateada(LocalDate fecha) {
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String fechaFormateada = fecha.format(formato);
		 return fechaFormateada;
	}
	
	
}
