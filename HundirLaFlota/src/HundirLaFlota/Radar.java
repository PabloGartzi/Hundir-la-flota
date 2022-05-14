package HundirLaFlota;

import java.util.Random;

public class Radar {
	
	private int consultasPosibles;
	private Coordenada coordenada;
	private Barco barcoDetectado;
	private Random ran = new Random();
	
	public Radar() {
		setConsultasPosibles(3);
			
	}
	
	public Radar usarRadar(TableroBarco pTablero) {
		setCoordenada();
		setBarcoDetectado(buscarBarco(pTablero));
		return this;
	}

	private void setCoordenada() {
		coordenada = new Coordenada(ran.nextInt(10), ran.nextInt(10));
	}
	
	public Barco buscarBarco(TableroBarco pTablero) {
		Object[] listaCoordenadas;
		Coordenada primera = new Coordenada(coordenada.getX()-4, coordenada.getY()-4);
		Coordenada ultima = new Coordenada(coordenada.getX()+4, coordenada.getY()+4);
		listaCoordenadas = pTablero.getStreamCoordenadas(primera, ultima).filter(c -> pTablero.hayBarco(c) && !pTablero.getCasilla(c).getBarco().getHundido()).toArray();
		if(  listaCoordenadas.length != 0)
			return pTablero.getCasilla((Coordenada) listaCoordenadas[0]).getBarco();
		return null;
	}

	public int getConsultasPosibles() {
		return consultasPosibles;
	}

	public void setConsultasPosibles(int consultasPosibles) {
		this.consultasPosibles = consultasPosibles;
	}

	public Barco getBarcoDetectado() {
		return barcoDetectado;
	}
	
	private void setBarcoDetectado(Barco buscarBarco) {
		this.barcoDetectado = buscarBarco;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}
	

}
