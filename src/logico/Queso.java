package logico;

import java.io.Serializable;

public abstract class Queso implements Serializable {
 private float precioBase;
 private float precioUnitario;
 private static int id = 0;
 
 public float precioTotal() {
	 return precioBase + precioUnitario * volumen();
 }
public Queso(float precioBase, float precioUnitario) {
	super();
	this.precioBase = precioBase;
	this.precioUnitario = precioUnitario;
	id++;
}
public float getPrecioBase() {
	return precioBase;
}
public void setPrecioBase(float precioBase) {
	this.precioBase = precioBase;
}
public float getPrecioUnitario() {
	return precioUnitario;
}
public void setPrecioUnitario(float precioUnitario) {
	this.precioUnitario = precioUnitario;
}
public static int getId() {
	return id;
}
public static void setId(int id) {
	Queso.id = id;
}
public abstract float volumen();
}
