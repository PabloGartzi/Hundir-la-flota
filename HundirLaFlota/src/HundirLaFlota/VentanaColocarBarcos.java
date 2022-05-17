package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

import java.util.*;

public class VentanaColocarBarcos extends JFrame implements PropertyChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JTextPane txtpnTipobarco;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup eleccionCasilla = new ButtonGroup();
	private JButton btnNewButton;
	private HashMap<ButtonModel, Coordenada> botonesEleccion;
	private HashMap<Coordenada, JCheckBox> botonesCoordenadaBoton;
	private HashMap<ButtonModel, JCheckBox> botonesModelos;
	private Humano jHumano = Humano.getHumano();
	private Ordenador jOrdenador = Ordenador.getOrdenador();
	private TipoBarco[] barcosAColocar;
	private int barcosColocarIndiceIterador;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaColocarBarcos frame = new VentanaColocarBarcos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaColocarBarcos() {
		initialize();
	}

	private void initialize() {
		botonesEleccion = new HashMap<>();
		botonesCoordenadaBoton = new HashMap<>();
		botonesModelos = new HashMap<>();
		barcosAColocar = Juego.getMJuego().getTiposBarco();
		barcosColocarIndiceIterador = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getBtnNewButton(), BorderLayout.SOUTH);
		contentPane.add(getBtnNewButton_1(), BorderLayout.NORTH);
		jHumano.addObserver(this);
		for(int i = 0; i<10; i++) {
			for(int j=0; j<10; j++) {
				JCheckBox botonBarco = new JCheckBox();
				if(i%2!=0 && j%2!=0 || i%2==0 && j%2==0)
					botonBarco.setBackground(Color.GRAY);
				else
					botonBarco.setBackground(Color.LIGHT_GRAY);
				Coordenada coord = new Coordenada(i,j);
				eleccionCasilla.add(botonBarco);
				panel.add(botonBarco);
				botonesEleccion.put(botonBarco.getModel(), coord);
				botonesModelos.put(botonBarco.getModel(), botonBarco);
				botonesCoordenadaBoton.put(coord, botonBarco);
			}
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 0, 0, 0));
			panel_1.add(getTxtpnTipobarco());
			panel_1.add(getRadioButton_1());
			panel_1.add(getRadioButton_2());
		}
		return panel_1;
	}

	private JRadioButton getRadioButton_1() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Vertical");
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRadioButton_2() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Horizontal");
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}

	private JTextPane getTxtpnTipobarco() {
		if (txtpnTipobarco == null) {
			txtpnTipobarco = new JTextPane();
			txtpnTipobarco.setBackground(SystemColor.menu);
			txtpnTipobarco.setText("PORTAAVIONES");
		}
		return txtpnTipobarco;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Colocar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colocarBarco();
				}
			});
		}
		return btnNewButton;
	}
	

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Colocar de forma aleatoria");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colocarHumanoAleatorio();
				}
			});
		}
		return btnNewButton_1;
	}
	
	private void colocarBarco() {
		if(eleccionCasilla.getSelection() != null) {
			System.out.println(botonesEleccion.get(eleccionCasilla.getSelection()));
				if(!coordenadasDentro(botonesEleccion.get(eleccionCasilla.getSelection()), barcosAColocar[barcosColocarIndiceIterador].getTamano(),rdbtnNewRadioButton.isSelected())) {
					mostrarError("El barco está fuera del tablero, elije otra posición");
				}
				else {
					enviarInformacionBarco();
				}
		}
		else {
			mostrarError("Elije una casilla");
		}
	}
	
	private void enviarInformacionBarco(){	
		if(!jHumano.hayBarcoEnZona(barcosAColocar[barcosColocarIndiceIterador], botonesEleccion.get(eleccionCasilla.getSelection()), rdbtnNewRadioButton.isSelected())) {
			jHumano.colocarBarco(barcosAColocar[barcosColocarIndiceIterador], botonesEleccion.get( eleccionCasilla.getSelection()), rdbtnNewRadioButton.isSelected());
			pintarCasillas(barcosAColocar[barcosColocarIndiceIterador].getTamano(), rdbtnNewRadioButton.isSelected(), botonesEleccion.get(eleccionCasilla.getSelection()));
			barcosColocarIndiceIterador += 1;
			if(barcosColocarIndiceIterador == barcosAColocar.length) {
				colocarOrdenador();
				this.setVisible(false);
				VentanaJuego vJuego = new VentanaJuego();
				vJuego.setVisible(true);
			}
			else
				txtpnTipobarco.setText(barcosAColocar[barcosColocarIndiceIterador].toString());
		}
		else {
			HayBarcoZona vBarcoZona = new HayBarcoZona();
			vBarcoZona.setVisible(true);
			eleccionCasilla.clearSelection();
			buttonGroup.clearSelection();
		}
	}

	
	private void colocarOrdenador() {
		jOrdenador.colocarBarcosAleatorio(barcosAColocar);
	}
	
	private void colocarHumanoAleatorio() {
		jHumano.colocarBarcosAleatorio(barcosAColocar);
		colocarOrdenador();
		this.setVisible(false);
		VentanaJuego vJuego = new VentanaJuego();
		vJuego.setVisible(true);
	}
	
	private boolean coordenadasDentro(Coordenada pCoord, int pTamano, boolean pDireccion) {
		if(pDireccion)
			return pCoord.getX()+pTamano-1<=9;
		return pCoord.getY()+pTamano-1<=9;
	}
	
	
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("barcoColocado")) {
			pintarCasillas(((Barco) evt.getNewValue()).getTamano(), ((Barco) evt.getNewValue()).getOrientacion(), ((Barco)evt.getNewValue()).getCoordenadaIncial());
		}
	}
	
	private void mostrarError(String pString) {
		CoordenadasFuera vCoorFue = new CoordenadasFuera();
		vCoorFue.setVisible(true);
		vCoorFue.setText(pString);
		eleccionCasilla.clearSelection();
		buttonGroup.clearSelection();
	}
	
	private void pintarCasillas(int pNumeroCasillas, boolean pDireccion, Coordenada pPrimeraCoordenada) {
		if(pDireccion) {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX()+i, pPrimeraCoordenada.getY());
				botonesCoordenadaBoton.get(nCoord).setBackground(Color.YELLOW);
			}
		}
		else {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX(), pPrimeraCoordenada.getY()+i);
				botonesCoordenadaBoton.get(nCoord).setBackground(Color.YELLOW);
			}
		}
	}
	
}
