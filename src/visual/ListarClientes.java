package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import logico.Cliente;
import logico.Factura;
import logico.Queso;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ListarClientes extends JFrame {
	private ArrayList<Cliente> misClientes;
	private ArrayList <Factura> misFacturas;
	private ArrayList<Queso> misQuesos;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes frame = new ListarClientes();
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
	public ListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel dataModel = new DefaultTableModel();
		table = new JTable();
		table.setBounds(12, 12, 416, 194);
		contentPane.add(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		btnCerrar.setBounds(297, 222, 114, 25);
		contentPane.add(btnCerrar);
		
			addWindowListener(new WindowAdapter() {
				int contador = 0;
				@Override
				public void windowActivated(WindowEvent e) {
					for (Cliente cliente : misClientes) {
						dataModel.insertRow(contador, new Object[] { cliente.getCedula(), cliente.getNombre(),
								cliente.getDireccion(), cliente.getTelefono() });
						contador++;
					}
				}
			});
			table.setModel(dataModel);
			btnCerrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Main main = new Main();
					 main.obtenerClientes(misClientes);
					 main.obtenerFacturas(misFacturas);
					 main.obtenerQuesos(misQuesos);
					 main.setVisible(true);
					 dispose();
				}
			});
	}

}
