package HundirLaFlota;

import java.lang.reflect.Array;

public class prueba {
	public static void main(String[] args) {
		String[][] listaP = new String[3][3];
		listaP[0][0] = "Hola";
		listaP[0][1] = "Hola1";
		listaP[0][2] = "Hola2";
		listaP[1][0] = "Hola3";
		listaP[1][1] = "Hola4";
		listaP[1][2] = "Hola5";
		listaP[2][0] = "Hola6";
		listaP[2][1] = "Hola7";
		listaP[2][2] = "Hola8";
		
		System.out.println(Array.asList(listaP).indexOf("Hola7"));
	}

}
