package ucv;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField codigo = configureText("C\u00F3digo", 10, 10, 120);
	private JTextField nombre = configureText("Nombre", 140, 10, 220);
	private JTextField sueldo = configureText("Sueldo Base", 10, 60, 120);
	private JTextField extras = configureText("Horas Extras", 140, 60, 180);

	@SuppressWarnings("rawtypes")
	private JComboBox seguro = configureComboBox("Tipo de Seguro", new String[] { "AFP", "SNP" }, 370, 10, 140);
	@SuppressWarnings("rawtypes")
	private JComboBox area = configureComboBox("Area", new String[] { "Sistemas", "Administración", "Marketing" }, 330,
			60, 180);

	private Empleados empleados;

	private final Font tahoma12 = new Font("Tahoma", Font.PLAIN, 12);

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

	public Ejercicio01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 480);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(codigo);
		contentPane.add(nombre);
		contentPane.add(sueldo);
		contentPane.add(extras);

		contentPane.add(seguro);
		contentPane.add(area);

		JTextArea txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(10, 110, 500, 280);
		contentPane.add(txtArea);

		JButton btnCrear = new JButton("Crear Objeto");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double sueldoBase, horasExtra;
				try {
				sueldoBase = Double.parseDouble(sueldo.getText());
				horasExtra = Double.parseDouble(extras.getText());
				}
				catch(NumberFormatException number) {
					JOptionPane.showMessageDialog(null, "El sueldo base y las horas extras deben ser numeros reales");
					return;
				}
				empleados = new Empleados(codigo.getText(), nombre.getText(), area.getSelectedItem().toString(), sueldoBase,
						horasExtra, seguro.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Objeto creado correctamente");
			}
		});
		btnCrear.setFont(tahoma12);
		btnCrear.setBounds(10, 400, 110, 30);
		contentPane.add(btnCrear);

		JButton btnMostrar = new JButton("Mostrar Informacion del Objeto");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (empleados != null) {
					txtArea.append("Codigo\t\t\t: " + empleados.getCodigo() + "\n");
					txtArea.append("Nombre\t\t\t: " + empleados.getNombre() + "\n");
					txtArea.append("Seguro\t\t\t: " + empleados.getTipo_seg() + "\n");
					txtArea.append("Sueldo Base\t\t\t: " + empleados.getSueldoBase() + "\n");
					txtArea.append("Horas Extras\t\t\t: " + empleados.getHorasExtras() + "\n");
					txtArea.append("Area\t\t\t: " + empleados.getArea() + "\n");
					txtArea.append("Monto Externo\t\t\t: " + empleados.montoHExtras() + "\n");
					txtArea.append("Monto Seguro\t\t\t: " + empleados.montoSeguro() + "\n");
					txtArea.append("Monto EsSalud\t\t\t: " + empleados.montoEssalud() + "\n");
					txtArea.append("Monto de Descuentos\t\t: " + empleados.montoDescuentos() + "\n");
					txtArea.append("Sueldo Bruto\t\t\t: " + empleados.sueldoBruto() + "\n");
					txtArea.append("Sueldo Neto\t\t\t: " + empleados.sueldoNeto() + "\n");
					txtArea.append("==========================================================\n");
				} else {
					JOptionPane.showMessageDialog(null, "Primero debes crear el objeto");
				}
			}
		});
		btnMostrar.setFont(tahoma12);
		btnMostrar.setBounds(130, 400, 210, 30);
		contentPane.add(btnMostrar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.setText("");
				nombre.setText("");
				sueldo.setText("");
				extras.setText("");
				seguro.setSelectedIndex(0);
				area.setSelectedIndex(0);
				txtArea.setText("");
			}
		});
		btnLimpiar.setFont(tahoma12);
		btnLimpiar.setBounds(350, 400, 75, 30);
		contentPane.add(btnLimpiar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(435, 400, 75, 30);
		contentPane.add(btnSalir);
	}

	private JTextField configureText(String title, int x, int y, int w) {
		JTextField textField = new JTextField();
		textField.setFont(tahoma12);
		textField.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(x, y, w, 40);
		textField.setColumns(10);
		return textField;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox configureComboBox(String title, String[] args, int x, int y, int w) {
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(args));
		comboBox.setFont(tahoma12);
		comboBox.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), title,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setBounds(x, y, w, 40);
		return comboBox;
	}
}
