package alvaro.huamanilara.examen;

public class Carta {

	private String nombre;
	private Plato[]platos;
	private Bebida[] bebidas;
	
	public Carta(String nombre, Plato[] platos, Bebida[] bebidas) {
		super();
		this.nombre = nombre;
		this.platos = platos;
		this.bebidas = bebidas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Plato[] getPlatos() {
		return platos;
	}

	public void setPlatos(Plato[] platos) {
		this.platos = platos;
	}

	public Bebida[] getBebidas() {
		return bebidas;
	}

	public void setBebidas(Bebida[] bebidas) {
		this.bebidas = bebidas;
	}
	
	public void mostrarPlatoDisponibibles() {
		System.out.println("LOS PLATOS DISPONIBLES DE LA " + this.nombre );
		for(Plato plato:this.platos) {
			if(plato.isDisponible()) {
				System.out.println(plato.getNombre() + "     " + plato.getPrecio());
			}
		}
	}
}
