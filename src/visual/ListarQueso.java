package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cilindro;
import logico.Cliente;
import logico.Factura;
import logico.Queso;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.Color;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ListarQueso extends JFrame {

	private JPanel contentPane;
	private final JTable table = new JTable();
	private ArrayList<Queso> misQuesos = new ArrayList <Queso>();
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarQueso frame = new ListarQueso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void obtenerFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	public void obtenerQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}
	public void obtenerClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	/**
	 * Create the frame.
	 */
	public ListarQueso() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel dataModel = new DefaultTableModel();
		table.setModel(dataModel);
		dataModel.addColumn("Id");
		dataModel.addColumn("Precio");
		dataModel.addColumn("Tipo");
		table.setBounds(12, 12, 440, 302);
		contentPane.add(table);
		
		JButton btnCerrar = new JButton("Cerrar");
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
		btnCerrar.setBounds(305, 330, 114, 25);
		contentPane.add(btnCerrar);
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {
				 
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				int contador = 0;
				for(Queso queso: misQuesos) {
					dataModel.insertRow(contador,new Object[] {queso.getId(),queso.getPrecioUnitario()});
					contador++;
				}	
			}
		});
	}
}
