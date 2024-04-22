package ucv;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@SuppressWarnings("rawtypes")
	private JComboBox categoria = configureComboBox("Seleccione Categoría",
			new String[] { "PRINCIPAL", "AUXILIAR", "CONTRATADO" }, 10, 10);
	@SuppressWarnings("rawtypes")
	private JComboBox profesion = configureComboBox("Seleccione Profesión", new String[] { "TECNICO", "INGENIERO" },
			180, 10);
	@SuppressWarnings("rawtypes")
	private JComboBox turno = configureComboBox("Seleccione Turno", new String[] { "MAÑANA", "TARDE" }, 10, 65);

	private JTextField horas = configureText("Horas de Trabajo", 180, 65);
	private JTextField tardanzas = configureText("Num. Tardanzas", 10, 120);
	private JTextField faltas = configureText("Num. Faltas", 180, 120);

	private final Font tahoma12 = new Font("Tahoma", Font.PLAIN, 12);

	private Empleados empleados;

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
		setTitle("Calculo del sueldo neto de un empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 408);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(categoria);
		contentPane.add(profesion);
		contentPane.add(turno);

		contentPane.add(horas);
		contentPane.add(tardanzas);
		contentPane.add(faltas);

		JTextArea txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(10, 175, 500, 175);
		contentPane.add(txtArea);

		JButton btnCalcular = crearBoton("CALCULAR", 10);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleados = new Empleados(categoria.getSelectedItem().toString(),
						profesion.getSelectedItem().toString(), turno.getSelectedItem().toString(), getInt(horas),
						getInt(tardanzas), getInt(faltas));
				txtArea.append("INFORMACION DEL EMPLEADO\n\n");
				txtArea.append("Pago por Horas\t\t\t: " + empleados.getPago() + "\n");
				txtArea.append("Sueldo Bruto\t\t\t: " + empleados.getSueldoBruto() + "\n");
				txtArea.append("Desc. por Tardanza\t\t: " + empleados.getDescTardanzas() + "\n");
				txtArea.append("Desc. por Falta\t\t\t: " + empleados.getDescFaltas() + "\n");
				txtArea.append("Sueldo Neto\t\t\t: " + empleados.getSueldoNeto() + "\n");

				/**
				 * Descomentar esta zona en caso se requiera usar todo en la misma clase
				 * txtArea.append("INFORMACION DEL EMPLEADO\n\n"); txtArea.append("Pago por
				 * Horas\t\t\t: " + pago() + "\n"); txtArea.append("Sueldo Bruto\t\t\t: " +
				 * sueldoBruto() + "\n"); txtArea.append("Desc. por Tardanza\t\t: " +
				 * descTardanzas() + "\n"); txtArea.append("Desc. por Falta\t\t\t: " +
				 * descFaltas() + "\n"); txtArea.append("Sueldo Neto\t\t\t: " + sueldoNeto() +
				 * "\n");
				 **/
			}
		});
		contentPane.add(btnCalcular);

		JButton btnNuevo = crearBoton("NUEVO", 65);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoria.setSelectedIndex(0);
				profesion.setSelectedIndex(0);
				turno.setSelectedIndex(0);
				horas.setText("");
				tardanzas.setText("");
				faltas.setText("");
				txtArea.setText("");
				categoria.requestFocus();
				empleados = null;
			}
		});
		contentPane.add(btnNuevo);

		JButton btnSalir = crearBoton("SALIR", 120);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
	}

	private JButton crearBoton(String nombre, int y) {
		JButton boton = new JButton(nombre);
		boton.setBounds(350, y, 160, 45);
		return boton;
	}

	private int getInt(JTextField text) {
		try {
			return Integer.parseInt(text.getText());
		} catch (NumberFormatException e) {
			text.setText("0");
			return 0;
		}
	}

	private JTextField configureText(String title, int x, int y) {
		JTextField textField = new JTextField();
		textField.setFont(tahoma12);
		textField.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(x, y, 160, 45);
		textField.setColumns(10);
		return textField;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox configureComboBox(String title, String[] args, int x, int y) {
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(args));
		comboBox.setFont(tahoma12);
		comboBox.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), title,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setBounds(x, y, 160, 45);
		return comboBox;
	}

	private double pago() {
		// El sueldo minimo es de 18
		double sueldo = 18;
		// Sin importar el turno o categoria el ingeniero gana 5.0 mas
		if (profesion.getSelectedItem().toString().equals("INGENIERO"))
			sueldo += 5;
		// Sin importar la profesion o categoria la mañana gana 2.0 mas
		if (turno.getSelectedItem().toString().equals("MAÑANA"))
			sueldo += 2;
		// El principal gana 5 mas que el auxiliar, quien gana 5 mas que el contratado
		switch (categoria.getSelectedItem().toString()) {
		case "PRINCIPAL":
			sueldo += 5;
		case "AUXILIAR":
			sueldo += 5;
			break;
		}
		return sueldo;
	}

	private double sueldoBruto() {
		return pago() * getInt(horas);
	}

	private double descTardanzas() {
		return pago() * getInt(tardanzas);
	}

	private double descFaltas() {
		return 0.03 * getInt(faltas) * sueldoBruto();
	}

	private double sueldoNeto() {
		return sueldoBruto() - descTardanzas() - descFaltas();
	}
}
