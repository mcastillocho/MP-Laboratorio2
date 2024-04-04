package ucv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtValor1 = configureText(10, 48, true);
	private JTextField txtValor2 = configureText(172, 48, true);
	private JTextField txtSuma = configureText(10, 224, false);
	private JTextField txtResta = configureText(172, 224, false);
	private JTextField txtMultiplicacion = configureText(10, 312, false);
	private JTextField txtDivision = configureText(172, 312, false);

	private Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio01 frame = new Ejercicio01();
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
	public Ejercicio01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 444);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(txtValor1);
		contentPane.add(txtValor2);
		contentPane.add(txtSuma);
		contentPane.add(txtResta);
		contentPane.add(txtMultiplicacion);
		contentPane.add(txtDivision);

		addLabel("Valor 1", 10, 22);
		addLabel("Valor 2", 172, 22);
		addLabel("Suma", 10, 198);
		addLabel("Resta", 172, 198);
		addLabel("Multiplicación", 10, 286);
		addLabel("División", 172, 286);

		JButton btnBorrar = addButton("Borrar", 10, 100);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSuma.setText("");
				txtResta.setText("");
				txtMultiplicacion.setText("");
				txtDivision.setText("");
			}
		});
		contentPane.add(btnBorrar);

		JButton btnCalcular = addButton("Calcular", 172, 100);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float value1 = getValue(txtValor1);
				float value2 = getValue(txtValor2);

				float suma = value1 + value2;
				float resta = value1 - value2;
				float multiplicacion = value1 * value2;
				float division = value1 / value2;

				txtSuma.setText(suma + "");
				txtResta.setText(resta + "");
				txtMultiplicacion.setText(multiplicacion + "");
				txtDivision.setText(division + "");
			}
		});
		contentPane.add(btnCalcular);

		JButton btnCerrar = addButton("Cerrar", 89, 150);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnCerrar);
	}

	private JButton addButton(String name, int x, int y) {
		JButton button = new JButton(name);
		button.setFont(tahoma14);
		button.setBounds(x, y, 120, 32);
		return button;
	}

	private void addLabel(String text, int x, int y) {
		JLabel label = new JLabel(text);
		label.setFont(tahoma14);
		label.setBounds(x, y, 120, 20);
		contentPane.add(label);
	}

	private JTextField configureText(int x, int y, boolean editable) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, 120, 32);
		textField.setFont(tahoma14);
		textField.setColumns(10);
		textField.setEditable(editable);
		return textField;
	}

	private float getValue(JTextField texto) {
		try {
			float valor = Float.parseFloat(texto.getText());
			return valor;
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, "El valor ingresado no es un número válido");
			texto.setText("0.1");
			return 0.1f;
		}
	}
}
