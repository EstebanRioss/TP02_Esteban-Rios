package ar.edu.unju.fi.ejercicio5Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5intefaces.Pago;

public class PagoEfectivo implements Pago {
	private Double MontoPagado;
	private LocalDate FechaPago;
	@Override
	public void ImprimirRecibo() {
		System.out.println(" RECIBO	");
		System.out.println("Fecha de pago: " + this.FechaFormateada(this.FechaPago));
		System.out.println("Monto pagado: " + this.MontoPagado);
		
	}
	
	@Override
	public void RealizarPago(double monto) {
		this.MontoPagado = monto - (monto * 0.10);
	}
	
	public Double getMontoPagado() {
		return MontoPagado;
	}
	public void setMontoPagado(Double montoPagado) {
		MontoPagado = montoPagado;
	}
	public LocalDate getFechaPago() {
		return FechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		FechaPago = fechaPago;
	}
	public String FechaFormateada(LocalDate fecha) {
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String fechaFormateada = fecha.format(formato);
		 return fechaFormateada;
	}
	
	
}
