package logico;

public class CilindroHueco extends Cilindro {
    private float radioCilindroHueco;
    private float radioInterior;
	public CilindroHueco(float radio, float longitud,float radiocilindrohueco,float radiointerior) {
		super(radio, longitud, radiointerior, radiointerior);
		this.radioCilindroHueco = radiocilindrohueco;
		this.radioInterior = radiointerior;
		// TODO Auto-generated constructor stub
	}
  public float areaBase () {
	  return 0;
  }
}
