package visual;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cilindro;
import logico.Cliente;
import logico.Factura;
import logico.Queso;
import logico.Queseria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowStateListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private Queseria queseria = Queseria.getInstance();

	// private Queso queso = new Cilindro(14,14,12,12);
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
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void obtenerQuesos(ArrayList<Queso> misQuesos) {
		queseria.setMisQuesos(misQuesos);
	}

	public void obtenerFacturas(ArrayList<Factura> misFacturas) {
		queseria.setMisFacturas(misFacturas);
	}

	public void obtenerClientes(ArrayList<Cliente> misClientes) {
		queseria.setMisClientes(misClientes);
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				FileOutputStream queseria2;
				ObjectOutputStream queseriaWrite;
				try {
					queseria2 = new FileOutputStream("C:\\Users\\gesbi\\git\\Queseria\\respaldo\\Queseria.dat");
					queseriaWrite = new ObjectOutputStream(queseria2);
					queseriaWrite.writeObject(Queseria.getInstance());		
				} catch(FileNotFoundException q1) {
					q1.printStackTrace();
				} catch(IOException q1) {
					q1.printStackTrace();
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuMain = new JMenuBar();
		setJMenuBar(menuMain);

		JMenu mnQueso = new JMenu("Quesos");
		mnQueso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		menuMain.add(mnQueso);

		JMenu mnCrearQueso_1 = new JMenu("Crear");
		mnCrearQueso_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComprarQueso comprarQueso = new ComprarQueso();
				comprarQueso.setVisible(true);
			}
		});
		mnCrearQueso_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FabricarQueso crearQueso = new FabricarQueso();
				crearQueso.obtenerQuesos(queseria.getMisQuesos());
				crearQueso.obtenerClientes(queseria.getMisClientes());
				crearQueso.obtenerFacturas(queseria.getMisFacturas());
				crearQueso.setVisible(true);
				dispose();
			}
		});
		mnQueso.add(mnCrearQueso_1);

		JMenu mnListar = new JMenu("Listar");
		mnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarQueso listarQueso = new ListarQueso();
				listarQueso.obtenerQuesos(queseria.getMisQuesos());
				listarQueso.obtenerFacturas(queseria.getMisFacturas());
				listarQueso.obtenerClientes(queseria.getMisClientes());
				listarQueso.setVisible(true);
				dispose();
			}
		});
		mnQueso.add(mnListar);

		JMenu mnComprar = new JMenu("Comprar");
		mnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ComprarQueso comprarQueso = new ComprarQueso();
				comprarQueso.obtenerQuesos(queseria.getMisQuesos());
				comprarQueso.obtenerClientes(queseria.getMisClientes());
				comprarQueso.obtenerFacturas(queseria.getMisFacturas());
				comprarQueso.setVisible(true);
				dispose();
			}
		});
		mnQueso.add(mnComprar);

		JMenu mnFactura = new JMenu("Factura");
		menuMain.add(mnFactura);
		
		JMenu mnListar_1 = new JMenu("Listar");
		mnListar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 ListarFacturas listaFacturas = new ListarFacturas();
			 listaFacturas.obtenerClientes(queseria.getMisClientes());
			 listaFacturas.obtenerQuesos(queseria.getMisQuesos());
			 listaFacturas.obtenerFacturas(queseria.getMisFacturas());
			 listaFacturas.setVisible(true);
			 dispose();
			}
		});
		mnFactura.add(mnListar_1);

		JMenu mnCliente = new JMenu("Clientes");
		menuMain.add(mnCliente);
		
		JMenu mnListar_2 = new JMenu("Listar");
		mnListar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 ListarClientes listarClientes = new ListarClientes();
			 listarClientes.obtenerClientes(queseria.getMisClientes());
			 listarClientes.obtenerQuesos(queseria.getMisQuesos());
			 listarClientes.obtenerFacturas(queseria.getMisFacturas());
			 listarClientes.setVisible(true);
			 dispose();
			}
		});
		mnCliente.add(mnListar_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
