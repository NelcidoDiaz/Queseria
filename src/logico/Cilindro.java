package logico;

public class Cilindro extends Queso  {
	private double radio;
	private float longitud;

	public Cilindro(float radio, float longitud,float precioBase,float precioUnitario) {
		super(precioBase, precioUnitario);
		this.radio = radio;
		this.longitud = longitud;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
   public float volumen() {
	 return (float) (Math.PI * Math.pow(radio, 2) * longitud);  
   }
 
}
