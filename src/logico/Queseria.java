package logico;

import java.util.ArrayList;

public class Queseria {
    private ArrayList <Queso> misQuesos = new ArrayList <Queso>();
    private ArrayList <Factura> misFacturas = new ArrayList <Factura>();
    private ArrayList <Cliente> misClientes = new ArrayList <Cliente>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
   public void crearQueso(){
	   
   }
public ArrayList<Queso> getMisQuesos() {
	return misQuesos;
}
public void setMisQuesos(ArrayList<Queso> misQuesos) {
	this.misQuesos = misQuesos;
}
public ArrayList<Factura> getMisFacturas() {
	return misFacturas;
}
public void setMisFacturas(ArrayList<Factura> misFacturas) {
	this.misFacturas = misFacturas;
}
public ArrayList<Cliente> getMisClientes() {
	return misClientes;
}
public void setMisClientes(ArrayList<Cliente> misClientes) {
	this.misClientes = misClientes;
}
public void agregarQuesoCilindrico(Cilindro cilindro) {
 misQuesos.add(cilindro);
}
}
