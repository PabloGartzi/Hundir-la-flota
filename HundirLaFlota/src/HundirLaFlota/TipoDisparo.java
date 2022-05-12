package HundirLaFlota;

public enum TipoDisparo {
	BOMBA(0, 0), MISIL(1, 10), ESCUDO(2, 20), RADAR(3, 20);
	
	private final int ordenArma;
	private final int precio;
	
	
	private TipoDisparo(int pOrden, int pPrecio) {
		this.ordenArma = pOrden;
		this.precio = pPrecio;
	}
	
	public int getOrden() {
		return this.ordenArma;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}
