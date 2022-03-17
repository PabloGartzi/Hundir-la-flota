package HundirLaFlota;

import java.util.ArrayList;

public abstract class Jugador {
	
	private int dinero;
	private ArrayList<Integer> listaArmas;
	private TableroDisparo tableroDisparo;
	private TableroBarco tableroBarco;
	
	public Jugador() {
		
	}
	
	public boolean disparar(Integer pX, Integer pY) {
		return false;
	}
	
	public boolean reparar() {
		return false;
	}
	
	public boolean colocarBarco() {
		return false;
	}
	
	public TableroDisparo getTableroDisparo() {
		return tableroDisparo;
	}
	
	public TableroBarco getTableroDisparo() {
		return tableroBarco;
	}
	
}
