package HundirLaFlota;

import java.util.Random;

public class Ordenador extends Jugador {
	
	private static Ordenador mOrdenador = new Ordenador();
	private Random ran = new Random();
	
	private Ordenador() {
		mOrdenador = this;
	}
	
	public static Ordenador getOrdenador() {
		return mOrdenador;
	}
	
	public void colocarBarcos(TipoBarco[] pListaTipoBarcos ) {
		for(int i=0; i<pListaTipoBarcos.length; i++) {
			Boolean bool = ran.nextBoolean();
			Coordenada coord = new Coordenada(ran.nextInt(10), ran.nextInt(10));
			
			if(!this.hayBarcoEnZona(pListaTipoBarcos[i], coord, bool) && coordenadasDentro(coord, pListaTipoBarcos[i].getTamano(), bool)) {
				this.colocarBarco(pListaTipoBarcos[i], coord, bool);
			}
			else {
				i -= 1;
			}
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(this.getTableroBarco().getTabla()[i][j].getHayBarco())
					System.out.print("B");
				else
					System.out.print("0");
			}
			System.out.println("");
			
		}
		
	}
	
	private boolean coordenadasDentro(Coordenada pCoord, int pTamano, boolean pDireccion) {
		if(pDireccion)
			return pCoord.getX()+pTamano-1<=9;
		return pCoord.getY()+pTamano-1<=9;
	}

	public void disparar() {
		this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.BOMBA);
		
	}
	

}