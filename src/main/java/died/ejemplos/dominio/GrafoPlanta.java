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
		
		Ruta r1 = new Ruta(1, p1, p2, 50.0, 10.0, 100.0);
		Ruta r2 = new Ruta(2, p2, p3, 10.0, 2.0, 100.0);
		Ruta r3 = new Ruta(3, p4, p6, 240.0, 50.0, 100.0);
		Ruta r4 = new Ruta(4, p5, p3, 60.0, 12.0, 100.0);
		
		gp.addNodo(p1);
		gp.addNodo(p2);
		gp.conectar(p1, p2);
		
		System.out.println(gp.getAdyacentes(p1));
		
	}
}
