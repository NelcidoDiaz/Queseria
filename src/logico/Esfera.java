package logico;

public class Esfera  extends Queso{
 private float radioEsfera;
	public float volumen() {
		return (float) ((4 / 3) * Math.PI * Math.pow(radioEsfera, 3));
	}
	public Esfera(float precioBase, float precioUnitario, float radioEsfera) {
		super(precioBase, precioUnitario);
		this.radioEsfera = radioEsfera;
	}
	 
}
