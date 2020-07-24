package died.ejemplos.dominio;

import java.time.LocalTime;

import Grafos.Grafo;

public class GrafoPlanta extends Grafo<Planta> {
	
	public static void main(String[] args) {

		GrafoPlanta gp = new GrafoPlanta();
		
		Planta p1 = new Planta(1, "Planta 1");
		Planta p2 = new Planta(2, "Planta 2");
		Planta p3 = new Planta(3, "Planta 3");
		Planta p4 = new Planta(4, "Planta 4");
		Planta p5 = new Planta(5, "Planta 5");
		Planta p6 = new Planta(6, "Planta 6");
		
		LocalTime ahora = LocalTime.now();
		Ruta r1 = new Ruta(1, p1, p2, 50.0, ahora, 100.0);
		
		gp.addNodo(p1);
		gp.addNodo(p2);
		gp.conectar(p1, p2, r1);
		
		System.out.println(gp.getAristas());
		
	}
}
