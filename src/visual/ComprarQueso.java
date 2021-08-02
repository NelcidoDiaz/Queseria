package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import logico.Queso;
import logico.Factura;
import logico.Fichero;
import logico.Queseria;
import logico.Cilindro;
import logico.Cliente;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.beans.PropertyChangeEvent;

public class ComprarQueso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private ArrayList<Queso> misQuesos;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Queso> quesosSeleccionados = new ArrayList<Queso>();
	private Cliente cliente;
	private JTable table;
	private JTextField txtCedula;
	private JTable tQuesos;
	private JTable tQuesosComprados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarQueso frame = new ComprarQueso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void obtenerQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}

	public void obtenerFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public void obtenerClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	/**
	 * Create the frame.
	 */
	public ComprarQueso() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(353, 441, 217, 49);
		contentPane.add(panel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main main = new Main();
				main.setVisible(true);
				main.obtenerQuesos(misQuesos);
				main.obtenerClientes(misClientes);
				main.obtenerFacturas(misFacturas);
				dispose();
			}
		});
		btnCancelar.setBounds(12, 24, 98, 25);
		panel.add(btnCancelar);

		JButton btnCrear = new JButton("Crear");

		btnCrear.setBounds(122, 24, 83, 25);
		panel.add(btnCrear);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 27, 66, 15);
		contentPane.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 69, 66, 15);
		contentPane.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 107, 66, 15);
		contentPane.add(lblDireccion);

		txtNombre = new JTextField();
		txtNombre.setBounds(105, 25, 124, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 67, 124, 19);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(105, 105, 124, 19);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(319, 27, 66, 15);
		contentPane.add(lblPrecio);

		JLabel lblPrecioResultado = new JLabel("0");
		lblPrecioResultado.setBounds(430, 27, 66, 15);
		contentPane.add(lblPrecioResultado);

		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel();
		table.setModel(dataModel);
		dataModel.addColumn("Cedula");
		dataModel.addColumn("Nombre");
		dataModel.addColumn("Direccion");
		dataModel.addColumn("Telefono");
		table.setBounds(12, 145, 558, 124);
		contentPane.add(table);

		txtCedula = new JTextField();

		txtCedula.setBounds(358, 105, 124, 19);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		tQuesosComprados = new JTable();
		tQuesos = new JTable();
		DefaultTableModel QuesosdataModel = new DefaultTableModel();
		DefaultTableModel QuesosCompradosdataModel = new DefaultTableModel();

		QuesosCompradosdataModel.addColumn("Id");
		QuesosCompradosdataModel.addColumn("Precio");
		tQuesos.setModel(QuesosdataModel);
		tQuesosComprados.setModel(QuesosCompradosdataModel);
		QuesosdataModel.addColumn("Id");
		QuesosdataModel.addColumn("Precio");
		tQuesos.setBounds(12, 281, 224, 162);
		contentPane.add(tQuesos);

		tQuesosComprados.setBounds(353, 281, 224, 162);
		contentPane.add(tQuesosComprados);

		JLabel lblCedula_1 = new JLabel("Cedula");
		lblCedula_1.setBounds(274, 107, 66, 15);
		contentPane.add(lblCedula_1);
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {

			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				for (Cliente cliente : misClientes) {
					dataModel.insertRow(contador, new Object[] { cliente.getCedula(), cliente.getNombre(),
							cliente.getDireccion(), cliente.getTelefono() });
					contador++;
				}
				contador = 0;
				for (Queso queso : misQuesos) {
					QuesosdataModel.insertRow(contador, new Object[] { queso.getId(), queso.getPrecioUnitario() });
					contador++;
				}
			}
		});
		tQuesosComprados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int contador = 0;
				for (Queso queso : misQuesos) {
					if (tQuesos.isRowSelected(contador) == true) {
						QuesosdataModel.insertRow(contador, new Object[] { queso.getId(), queso.getPrecioUnitario() });
						QuesosCompradosdataModel.removeRow(contador);
					}
				}
				contador++;
			}
		});
		tQuesos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int contador = 0;
				for (Queso queso : misQuesos) {
					if (tQuesos.isRowSelected(contador) == true) {
						QuesosCompradosdataModel.insertRow(contador,
								new Object[] { queso.getId(), queso.getPrecioUnitario() });
						if (queso instanceof Cilindro == true) {
							String value = String
									.valueOf((queso.getPrecioBase() + queso.getPrecioUnitario()) * queso.volumen());
							lblPrecioResultado.setText(value);
						}

						quesosSeleccionados.add(queso);
						QuesosdataModel.removeRow(contador);
					}
				}
				contador++;
			}
		});
		txtCedula.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				for (Cliente cliente : misClientes) {
					if (cliente.getCedula().equals(txtCedula.getText()) == true) {
						txtNombre.setText(cliente.getNombre());
						txtTelefono.setText(cliente.getTelefono());
						txtDireccion.setText(cliente.getDireccion());
					}
				}
			}
		});
		btnCrear.addMouseListener(new MouseAdapter() {
			public void limpiar() {
				txtNombre.setText("");
				txtTelefono.setText("");
				txtDireccion.setText("");
				txtCedula.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cliente = new Cliente(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(),
						txtCedula.getText());
				Factura nuevaFactura = new Factura(quesosSeleccionados, cliente);
				misFacturas.add(nuevaFactura);
				try {
					Fichero archivo = new Fichero("git\\Queseria\\factura\\factura.txt");
					archivo.crearArchivo();
					archivo.escribirArchivo(nuevaFactura);
				}
				catch(IOException ioe) {
					JOptionPane.showMessageDialog(null, "Error "+ioe);
				}
				limpiar();
				System.out.println("Factura realizada");
			}
		});
	}
}
