package ar.edu.unju.fi.ejercicio3Main;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.ejercicio3Constantes.Constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		List <Provincia> ListaProv = new ArrayList<Provincia>();
		ListaProv.add(Provincia.CATAMARCA);
		ListaProv.add(Provincia.JUJUY);
		ListaProv.add(Provincia.LA_RIOJA);
		ListaProv.add(Provincia.SALTA);
		ListaProv.add(Provincia.SANTIAGO_DEL_ESTERO);
		ListaProv.add(Provincia.TUCUMAN);
		
		for(Provincia f : ListaProv) {
			System.out.println("Los datos de las provincia " + f + " son: " );
			System.out.println("Poblacion: " + f.getPoblacion() + " Superficie: " + f.getSuperficie() + " Densidad: " + f.getDensidadPoblacional());
		}
	}

}
