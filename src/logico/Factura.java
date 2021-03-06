package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
 private ArrayList <Queso> misQuesos = new ArrayList <Queso>();
 private Cliente cliente;
 private float total;
 
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
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
 public String getClienteNombre() {
	 return cliente.getNombre();
 }
 public int [] getQuesosId() {
	 int [] Ids = new int [100];
	 int contador = 0;
	 for(Queso queso: misQuesos) {
	  Ids[contador] = queso.getId();
	  contador++;
	 }
	 return Ids;
 }
 public float precioTotal() {
	 float total = 0;
	 for(Queso i: misQuesos) {
		 if(i!=null) {
			 total += i.precioTotal();
		 }
	 }
	 return total;
}
}
