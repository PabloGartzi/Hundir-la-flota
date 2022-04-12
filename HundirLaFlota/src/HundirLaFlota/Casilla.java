package HundirLaFlota;

public record Casilla(Coordenada pCoordenada, boolean pBarco) {
	public Coordenada getCoordenada() {
		return pCoordenada;
	}
	
	public boolean getHayBarco() {
		return pBarco;
	}
	
}
