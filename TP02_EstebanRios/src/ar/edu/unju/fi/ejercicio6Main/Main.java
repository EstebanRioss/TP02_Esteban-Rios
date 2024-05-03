package ar.edu.unju.fi.ejercicio6Main;

import ar.edu.unju.fi.ejercicio6Model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6Model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio6Interfaces.funcionales.*;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Tanner", (byte)20, 186f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		
		if(Converter.isNotNull(gato)) {
			FelinoSalvaje felino1 = converter.convert(gato);
			converter.mostrarObjeto(felino1);
		}
		else {
			System.out.println("El objeto es nulo");
		}
		
	}

}
