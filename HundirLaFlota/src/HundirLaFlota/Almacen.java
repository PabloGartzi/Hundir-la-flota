package HundirLaFlota;


public class Almacen {
	private static Almacen mAlmacen;
	private Integer[] listaArmamento;
	
	private Almacen() {
		listaArmamento = new Integer[4];
		listaArmamento[0]=10000;
		listaArmamento[1]=100;
		listaArmamento[2]=100;
		listaArmamento[3]=100;		
		mAlmacen = this;
	}
	
	public static Almacen getAlmacen() {
		return mAlmacen;
	}
	
	public void comprar(int pArma) {
		listaArmamento[pArma] -= 1;
	}

}
