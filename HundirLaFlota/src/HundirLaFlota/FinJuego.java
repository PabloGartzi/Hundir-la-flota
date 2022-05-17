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
import javax.swing.SwingConstants;

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
				panelTextoGanador.add(txtJuegoterminado);
				txtJuegoterminado.setEditable(false);
				txtJuegoterminado.setText(" JuegoTerminado");
				txtJuegoterminado.setColumns(10);
			}
			{
				JLabel gifBarco = new JLabel("");
				panelGIF.add(gifBarco);
				gifBarco.setIcon(new ImageIcon(getClass().getResource("/HundirLaFlota/BarcoGif2.gif").getFile()));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setGanador(String pGanador) {
		txtJuegoterminado.setText(pGanador);
	}

}
