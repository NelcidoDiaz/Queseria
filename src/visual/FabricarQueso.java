package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JButton;

import logico.Cilindro;
import logico.CilindroHueco;
import logico.Cliente;
import logico.Esfera;
import logico.Factura;
import logico.Queseria;
import logico.Queso;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FabricarQueso extends JFrame {

	private JPanel contentPane;
	private ArrayList<Queso> misQuesos = Queseria.getInstance().getMisQuesos(); ;
	private ArrayList<Factura> misFacturas = Queseria.getInstance().getMisFacturas();
	private ArrayList<Cliente> misClientes = Queseria.getInstance().getMisClientes();
	private final JLabel lblPrecioBase = new JLabel("Precio Base");
	private JTextField txtRadio;
	private JTextField txtLongitud;
	private JTextField txtRadioInterior;
	private JTextField txtRadioSegCilindro;
    private Main frame = new Main();
    private JTextField txtPrecioBase;
    private JTextField txtPrecioUnitario;
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
					FabricarQueso frame = new FabricarQueso();
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
	public FabricarQueso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 370);
		 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblPrecioBase.setBounds(25, 12, 113, 24);
		contentPane.add(lblPrecioBase);

		JLabel lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setBounds(22, 61, 103, 15);
		contentPane.add(lblPrecioUnitario);

		JComboBox cmbTipo = new JComboBox();

		cmbTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		cmbTipo.setModel(
				new DefaultComboBoxModel(new String[] { "<Seleciona>", "Cilindrico", "Cilindrico Hueco", "Esferico" }));
		cmbTipo.setBounds(206, 101, 113, 24);
		contentPane.add(cmbTipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 106, 66, 15);
		contentPane.add(lblTipo);

		JPanel panel = new JPanel();
		panel.setBounds(264, 279, 217, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 frame.setVisible(true);
			 frame.obtenerQuesos(misQuesos);
		     dispose();
			}
		});
		btnCancelar.setBounds(12, 24, 98, 25);
		panel.add(btnCancelar);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(122, 24, 83, 25);
		panel.add(btnCrear);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 120, 402, 141);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRadio = new JLabel("Radio");
		lblRadio.setVisible(false);
		lblRadio.setBounds(35, 22, 66, 15);
		panel_1.add(lblRadio);

		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setVisible(false);
		lblLongitud.setBounds(35, 61, 66, 15);
		panel_1.add(lblLongitud);

		JLabel lblRadioInterior = new JLabel("Radio Interior");
		lblRadioInterior.setVisible(false);
		lblRadioInterior.setBounds(35, 99, 114, 15);
		panel_1.add(lblRadioInterior);

		JLabel lblRadioSegundoClindro = new JLabel("Radio Segundo Clindro");
		lblRadioSegundoClindro.setVisible(false);
		lblRadioSegundoClindro.setBounds(34, 126, 169, 15);
		panel_1.add(lblRadioSegundoClindro);

		txtRadio = new JTextField();
		txtRadio.setVisible(false);
		txtRadio.setBounds(232, 20, 124, 19);
		panel_1.add(txtRadio);
		txtRadio.setColumns(10);

		txtLongitud = new JTextField();
		txtLongitud.setVisible(false);
		txtLongitud.setBounds(232, 57, 124, 19);
		panel_1.add(txtLongitud);
		txtLongitud.setColumns(10);

		txtRadioInterior = new JTextField();
		txtRadioInterior.setVisible(false);
		txtRadioInterior.setBounds(232, 97, 124, 19);
		panel_1.add(txtRadioInterior);
		txtRadioInterior.setColumns(10);

		txtRadioSegCilindro = new JTextField();
		txtRadioSegCilindro.setVisible(false);
		txtRadioSegCilindro.setBounds(232, 124, 124, 19);
		panel_1.add(txtRadioSegCilindro);
		txtRadioSegCilindro.setColumns(10);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setBounds(139, 15, 124, 19);
		contentPane.add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(149, 57, 124, 19);
		contentPane.add(txtPrecioUnitario);
		txtPrecioUnitario.setColumns(10);
		btnCrear.addMouseListener(new MouseAdapter() {
			 public final void limpiar() {
				 txtRadioInterior.setText("");
				 txtRadioSegCilindro.setText("");
				 txtRadioSegCilindro.setText("");
				 txtLongitud.setText("");
				 txtRadio.setText("");
			   }
			@Override
			public void mouseClicked(MouseEvent e) {
				float precioBase = Float.parseFloat(txtPrecioBase.getText());
				float precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());
				float radio = Float.parseFloat(txtRadio.getText());
				if (cmbTipo.getSelectedItem().equals("Cilindrico")) {
					float longitud = Float.parseFloat(txtLongitud.getText());
					Cilindro quesoCilindrico = new Cilindro(precioBase, precioUnitario, radio, longitud);
					misQuesos.add(quesoCilindrico);
				} else if (cmbTipo.getSelectedItem().equals("Cilindrico Hueco")) {
					float radioInterior = Float.parseFloat(txtRadioInterior.getText());
					float segundoCilindro = Float.parseFloat(txtRadioSegCilindro.getText());
					CilindroHueco quesoCilindroHueco = new CilindroHueco(precioBase,precioUnitario,segundoCilindro,radioInterior);
                    misQuesos.add(quesoCilindroHueco);
				} else if (cmbTipo.getSelectedItem().equals("Esferico")) {
					Esfera quesoEsfera = new Esfera(precioBase,precioUnitario,radio);
					misQuesos.add(quesoEsfera);
				}
				limpiar();
			}
		});
		cmbTipo.addActionListener(new ActionListener() {
			public final void ocultar() {
				lblRadio.setVisible(false);
				lblLongitud.setVisible(false);
				lblRadioSegundoClindro.setVisible(false);
				lblRadioInterior.setVisible(false);
				txtRadio.setVisible(false);
				txtLongitud.setVisible(false);
				txtRadioInterior.setVisible(false);
				txtRadioSegCilindro.setVisible(false);
			}

			public void actionPerformed(ActionEvent arg0) {
				if (cmbTipo.getSelectedItem().equals("Cilindrico")) {
					ocultar();
					lblRadio.setVisible(true);
					lblLongitud.setVisible(true);
					txtRadio.setVisible(true);
					txtLongitud.setVisible(true);
				} else if (cmbTipo.getSelectedItem().equals("Cilindrico Hueco")) {
					ocultar();
					lblRadio.setVisible(true);
					lblLongitud.setVisible(true);
					lblRadioSegundoClindro.setVisible(true);
					lblRadioInterior.setVisible(true);
					txtRadio.setVisible(true);
					txtLongitud.setVisible(true);
					txtRadioInterior.setVisible(true);
					txtRadioSegCilindro.setVisible(true);
				} else if (cmbTipo.getSelectedItem().equals("Esferico")) {
					ocultar();
					lblRadio.setVisible(true);
					txtRadio.setVisible(true);
				} else {
					ocultar();
				}
			}
		});
	}
}
