package HundirLaFlota;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarcoTest {
	
	private Barco barco1;
	private Barco barco2;
	private Barco barco3;
	private Barco barco4;

	@BeforeEach
	void setUp() throws Exception {
		barco1 = new Barco(TipoBarco.PORTAAVIONES, new Coordenada(0,3), false);
		barco2 = new Barco(TipoBarco.DESTRUCTOR, new Coordenada(0,3), true);
		barco3 = new Barco(TipoBarco.FRAGATA, new Coordenada(0,3), false);
		barco4 = new Barco(TipoBarco.SUBMARINO, new Coordenada(0,3), true);
		
		barco1.setHundido();
		barco3.setTurnosEscudo(1);
			
	}

	@Test
	void testGetTipoBarco() {
		if(!barco2.getTipoBarco().equals(TipoBarco.DESTRUCTOR))
			fail("No es el tipo de barco esperado");
	}

	@Test
	void testGetHundido() {
		if(!barco1.getHundido() || barco3.getHundido())
			fail("No es la situación esperada");
	}

	@Test
	void testGetTurnosEscudo() {
		if(!(barco3.getTurnosEscudo()==1) || barco4.getTurnosEscudo()!=0)
			fail("No tiene el turno de escudos esperado");
	}

}
