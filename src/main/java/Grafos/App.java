package Grafos;

public class App {

	public static void main(String[] args) {

		Grafo<Integer> g1 = new Grafo<Integer>();

		g1.addNodo(4);
		g1.addNodo(8);
		g1.addNodo(12);
		g1.addNodo(16);
		g1.addNodo(18);
		g1.conectar(4, 8);
		g1.conectar(8, 12);
		g1.conectar(4, 12);
		g1.conectar(12, 16);
		//g1.conectar(16, 18);
		//g1.conectar(8, 12);
		//g1.conectar(12, 4);

		/**     8
		 *    / |  
		 *  4   |
		 *    \ |
		 *      12 ---> 16
		 */

//		System.out.println(g1.hayCamino(g1.getNodo(8), g1.getNodo(4)));
		System.out.println(g1.caminos(g1.getNodo(4), g1.getNodo(16)));
		//System.out.println(g1.funcion(g1.getNodo(4), 2));
	}

}
