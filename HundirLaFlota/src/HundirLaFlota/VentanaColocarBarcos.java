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
import java.awt.event.ActionEvent;

import java.util.*;
import java.util.stream.Collectors;

public class VentanaColocarBarcos extends JFrame {

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
	private Jugador jHumano = Humano.getHumano();
	private TipoBarco[] barcosAColocar;
	private int barcosColocarIndiceIterador;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getBtnNewButton(), BorderLayout.SOUTH);
		
		for(int i = 0; i<10; i++) {
			for(int j=0; j<10; j++) {
				JCheckBox botonBarco = new JCheckBox();
				if(i%2!=0 && j%2!=0 || i%2==0 && j%2==0)
					botonBarco.setBackground(Color.BLACK);
				else
					botonBarco.setBackground(Color.WHITE);
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
			txtpnTipobarco.setText("TipoBarco");
		}
		return txtpnTipobarco;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Colocar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(botonesEleccion.get(eleccionCasilla.getSelection()));
					//TODO no colocar en casillas de fuera
					if(rdbtnNewRadioButton.isSelected()) {
						if(botonesEleccion.get(eleccionCasilla.getSelection()).getX() + barcosAColocar[barcosColocarIndiceIterador].getTamano()-1 > 9) {
							CoordenadasFuera vCoorFue = new CoordenadasFuera();
							vCoorFue.setVisible(true);
							eleccionCasilla.clearSelection();
							buttonGroup.clearSelection();
						}
						else {
							enviarInformacionBarco();
						}
					}else {
						if(botonesEleccion.get(eleccionCasilla.getSelection()).getY() + barcosAColocar[barcosColocarIndiceIterador].getTamano()-1 > 9) {
							CoordenadasFuera vCoorFue = new CoordenadasFuera();
							vCoorFue.setVisible(true);
							eleccionCasilla.clearSelection();
							buttonGroup.clearSelection();
						}
						else {
							enviarInformacionBarco();
						}
					}
					
				}
			});
		}
		return btnNewButton;
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
		}
		else {
			HayBarcoZona vBarcoZona = new HayBarcoZona();
			vBarcoZona.setVisible(true);
			eleccionCasilla.clearSelection();
			buttonGroup.clearSelection();
		}
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
	
	private void colocarOrdenador() {
		
	}
}
