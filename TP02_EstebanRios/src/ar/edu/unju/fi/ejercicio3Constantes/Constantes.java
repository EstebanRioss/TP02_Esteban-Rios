package ar.edu.unju.fi.ejercicio3Constantes;

public class Constantes {
	public enum Provincia{
		JUJUY(718971,53219),
		SALTA(1441351,155488),
		TUCUMAN(1731820,22524),
		CATAMARCA(429602,102602),
		LA_RIOJA(383865,102602),
		SANTIAGO_DEL_ESTERO(1060906,136351);
		private String nombre;
	    private int poblacion;
	    private double superficie;
	    
	    Provincia(int poblacion, double superficie) {
	        
	        this.poblacion = poblacion;
	        this.superficie = superficie;
	    }
	    public String getNombre() {
	        return nombre;
	    }

	    public int getPoblacion() {
	        return poblacion;
	    }

	    public double getSuperficie() {
	        return superficie;
	    }

	    public double getDensidadPoblacional() {
	        return poblacion / superficie;
	    }
	}
}
