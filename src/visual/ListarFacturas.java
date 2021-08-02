package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Factura;
import logico.Queseria;
import logico.Queso;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import logico.Factura;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ListarFacturas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList <Factura> misFacturas = Queseria.getInstance().getMisFacturas();
	private ArrayList<Queso> misQuesos = Queseria.getInstance().getMisQuesos();;
	private ArrayList<Cliente> misClientes = Queseria.getInstance().getMisClientes();;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream queseria;
				FileOutputStream queseria2;
				ObjectInputStream queseriaRead;
				ObjectOutputStream queseriaWrite;
				try {
					queseria = new FileInputStream("C:\\Users\\gesbi\\git\\Queseria\\respaldo\\Queseria.dat");
					queseriaRead = new ObjectInputStream(queseria);
					Queseria temp = (Queseria) queseriaRead.readObject();
					Queseria.setControl(temp);
					queseriaRead.close();
				} catch (FileNotFoundException q) {
				
				} catch(IOException q) {
					
				}catch(ClassNotFoundException q) {
					q.printStackTrace();
				}
				try {
					ListarFacturas frame = new ListarFacturas();
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
	public ListarFacturas() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel facturas = new DefaultTableModel();
		facturas.addColumn("Nombre del cliente");
		facturas.addColumn("Cedula del cliente");
		facturas.addColumn("precio");
		table = new JTable();
		table.setModel(facturas);
		table.setBounds(5, 12, 423, 211);
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
		btnCerrar.setBounds(303, 233, 114, 25);
		contentPane.add(btnCerrar);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			 int contador = 0;
			 for(Factura factura: misFacturas) {
			  	facturas.insertRow(contador,new Object[] {factura.getCliente().getNombre(),factura.getCliente().getCedula(),factura.getTotal()} ); 
			 }
			}
		});
	}

}
