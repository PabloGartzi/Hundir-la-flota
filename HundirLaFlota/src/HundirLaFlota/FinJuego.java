package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class FinJuego extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelGIF = new JPanel();
	private JTextField txtJuegoterminado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FinJuego dialog = new FinJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FinJuego() {
		initialize();
	}

	private void initialize() {
		setTitle("Fin del Juego");
		setBounds(100, 100, 1212, 602);
		getContentPane().setLayout(new BorderLayout());
		panelGIF.setLayout(new FlowLayout());
		panelGIF.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelGIF, BorderLayout.CENTER);

		{
			JPanel panelTextoGanador = new JPanel();
			getContentPane().add(panelTextoGanador, BorderLayout.NORTH);
			{
				txtJuegoterminado = new JTextField();
				txtJuegoterminado.setFont(new Font("Tahoma", Font.BOLD, 20));
				panelTextoGanador.add(txtJuegoterminado);
				txtJuegoterminado.setEditable(false);
				txtJuegoterminado.setText(" JuegoTerminado");
				txtJuegoterminado.setColumns(10);
			}
			{
				JLabel gifBarco = new JLabel("");
				panelGIF.add(gifBarco);
				gifBarco.setIcon(new ImageIcon(getClass().getResource("/HundirLaFlota/BarcoGif3.gif").getFile()));
			}
		}
	}

	public void setGanador(String pGanador) {
		txtJuegoterminado.setText(pGanador);
	}

}
