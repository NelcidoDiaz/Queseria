package logico;

import java.util.ArrayList;

public class Factura {
 private ArrayList <Queso> misQuesos = new ArrayList <Queso>();
 private Cliente cliente;
 
public Factura(ArrayList<Queso> misQuesos, Cliente cliente) {
	super();
	this.cliente = cliente;
	this.misQuesos = misQuesos;
	this.cliente = cliente;
}
public ArrayList<Queso> getMisQuesos() {
	return misQuesos;
}
public void setMisQuesos(ArrayList<Queso> misQuesos) {
	this.misQuesos = misQuesos;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
 
}
