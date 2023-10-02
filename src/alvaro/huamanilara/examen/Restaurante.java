package alvaro.huamanilara.examen;

import java.util.Scanner;

public class Restaurante {

	private String nombre;

	public Restaurante(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static void main(String[] arrs) {
		Plato plato1=new Plato("arroz con pollo",12,false );
		Plato plato2=new Plato("tallarines verdes",10,true);
		Plato plato3=new Plato("pollo asado",15,true);
		Plato plato4=new Plato("trucha frita",20,true);
		Plato plato5=new Plato("lentejas con arroz con pescado frito",12,true );
		Plato[] platos1= {plato1,plato2,plato3};
		Plato[] platos2= {plato4,plato5};

		Bebida bebida1=new Bebida("chicha de jora", 4.50);
		Bebida bebida2=new Bebida("maracuya", 4.50);
		Bebida[] bebidas1= {bebida1};
		Bebida[] bebidas2= {bebida2};

		Carta carta1=new Carta("carta 1",platos1, bebidas1);
		Carta carta2=new Carta("carta 2",platos2,bebidas2);
		Carta[] cartas= {carta1,carta2};


		Restaurante restaurante=new Restaurante("Alvaro's resaurant");
		Carta carta =restaurante.mostrarCartas(cartas);
		restaurante.obtenerImporte(carta);
	}


	public Carta mostrarCartas(Carta[] cartas) {
		Carta cartaElegida=null;
		int opcion=0;
		while( opcion!=2 ) {
			opcion=0;
			for(Carta carta:cartas) {
				carta.mostrarPlatoDisponibibles();
			}
			System.out.println("Introduzca el nombre de la carta que desea:: ");
			Scanner scan=new Scanner(System.in);
			String cartaSeleccionada=scan.nextLine();

			for(Carta carta:cartas) {
				if(cartaSeleccionada.equalsIgnoreCase(carta.getNombre())) {
					cartaElegida=carta;
					System.out.println("Bena eleccion");
					opcion=2;
					break;
				}
			}

			if(cartaElegida==null) {
				scan=new Scanner(System.in);
				System.out.println("Desea continuar viendo las cartas: Si[1] o No[2] ");
				opcion=scan.nextInt();			

			}
		}
		return cartaElegida;
	}

	public void obtenerImporte(Carta carta) {
		if(carta!=null) {
			double importe=0;
			Plato[] platos= carta.getPlatos();
			Bebida[] bebidas=carta.getBebidas();

			for(Plato plato:platos) {
				if(plato.isDisponible()) {
					importe+=plato.getPrecio();
				}
			}

			for(Bebida bebida:bebidas) {
				importe+=bebida.getPrecio();
			}
			System.out.println("El importe es de: " + importe);
		}else {
			System.out.println("No hay importe por cobrar");
		}
	}


}
