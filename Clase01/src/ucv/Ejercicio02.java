package ucv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class Ejercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField lab = configureText(30);
	private JTextField inc = configureText(80);
	private JTextField ep = configureText(130);
	private JTextField total = configureText(180);

	private Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio02 frame = new Ejercicio02();
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
	public Ejercicio02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 520, 280);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addLabel("Informe de laboratorio (30%)", 30);
		addLabel("Investigación Formativa (40%)", 80);
		addLabel("Examen Parcial (30%)", 130);

		contentPane.add(lab);
		contentPane.add(inc);
		contentPane.add(ep);
		contentPane.add(total);

		JButton calcular = addButton("Calcular Promedio", calcularBtn(), 65, 180);
		contentPane.add(calcular);
	}

	private void addLabel(String text, int y) {
		JLabel label = new JLabel(text);
		label.setFont(tahoma14);
		label.setBounds(26, y, 244, 34);
		contentPane.add(label);
	}

	private JTextField configureText(int y) {
		JTextField textField = new JTextField();
		textField.setBounds(293, y, 144, 34);
		textField.setFont(tahoma14);
		textField.setColumns(10);
		return textField;
	}

	private JButton addButton(String name, ActionListener accion, int x, int y) {
		JButton button = new JButton(name);
		button.setFont(tahoma14);
		button.setBounds(x, y, 176, 34);
		button.addActionListener(accion);
		return button;
	}

	private ActionListener calcularBtn() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float laboratorio = getValue(lab) * 0.3f;
				float producto = getValue(inc) * 0.4f;
				float parcial = getValue(ep) * 0.3f;
				Float nota = (int) ((laboratorio + producto + parcial) * 100) / 100f;
				total.setText(String.valueOf(nota));
			}
		};
	}

	private float getValue(JTextField texto) {
		try {
			float valor = Float.parseFloat(texto.getText());
			if (valor > 20 || valor < 0) {
				throw new NumberFormatException();
			}
			return valor;
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, "El valor ingresado no es un número válido");
			texto.setText("0.0");
			return 0f;
		}
	}
}
