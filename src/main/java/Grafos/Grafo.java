package Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Grafo<T> {

	private List<Arista<T>> aristas;
	private List<Vertice<T>> vertices;
	
	//CONSTRUCTORES.
	public Grafo() {
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}
	public Grafo(List<Arista<T>> ari, List<Vertice<T>> ver) {
		this.aristas = ari;
		this.vertices = ver;
	}
	
	//METODOS.
	
	public List<Arista<T>> getAristas(){
		return this.aristas;
	}
	
	public void addNodo(Vertice<T> nodo) {
		this.vertices.add(nodo);
	}
	
	public void addNodo(T nodo) { 
		this.addNodo(new Vertice<T>(nodo)); 
	}
	
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}
	
	private void conectar(Vertice<T> n1, Vertice<T> n2, Number valor) {
		if(this.vertices.contains(n1) && this.vertices.contains(n2)) {
			this.aristas.add(new Arista<T>(n1, n2, valor));
		}
		else {
			System.out.println("El vertice no existe.");
		}
	}
	
	public void conectar(T n1, T n2) {
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}
	
	public void conectar(T n1, T n2, Number valor) {
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}
	
	public void conectar(Vertice<T> n1, Vertice<T> n2, Arista<T> a) {
		if(this.vertices.contains(n1) && this.vertices.contains(n2)) {
			this.aristas.add(a);
		}
		else {
			System.out.println("El vertice no existe.");
		}
	}
	
	public List<T> getAdyacentes(T valor){
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas) {
			if(enlace.getInicio().equals(unNodo)) {
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	
	private List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}

	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}
	
	public List<T> recorridoAnchura(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		Queue<Vertice<T>> colaPendientes = new LinkedList<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		colaPendientes.add(inicio);
		while(!colaPendientes.isEmpty()) {
			Vertice<T> actual = colaPendientes.poll();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes) {
				if(!marcados.contains(v)) {
					colaPendientes.add(v);
					marcados.add(v);
				}
			}
		}
		return resultado;
	}
	
	public List<T> recorridoProfundidad(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		Stack<Vertice<T>> pilaPendientes = new Stack<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pilaPendientes.push(inicio);
		while(!pilaPendientes.isEmpty()) {
			Vertice<T> actual = pilaPendientes.pop();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes) {
				if(!marcados.contains(v)) {
					pilaPendientes.push(v);
					marcados.add(v);
				}
			}
		}
		return resultado;
	}
	
	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}
	
	public List<T> recorridoTopologico(){
		List<T> resultado = new ArrayList<T>();
		Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
		for(Vertice<T> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){

			List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());

            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");

			for(Vertice<T> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<T> ady: this.getAdyacentes(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}

		System.out.println(resultado);
		return resultado;
 	}
	
    private boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
    	List<Vertice<T>> ady = this.getAdyacentes(v1);
        for(Vertice<T> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
    //RETORNA TRUE SI HAY UN CAMINO DE V1 A V2
    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2) {
    	List<Vertice<T>> adyacentes = getAdyacentes(v1);
    	if(adyacentes.isEmpty()) {
    		return false;
    	}
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return true;
    		}
    	}
    	return hayCamino(adyacentes.get(0), v2);
    }
    
    //RETORNA TRUE SI HAY UN CAMINO DE V1 A V2 DANDO AL MENOS N SALTOS.
    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2, Integer N) {
    	List<Vertice<T>> adyacentes = getAdyacentes(v1);
    	if(adyacentes.isEmpty()) {
    		return false;
    	}
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2) && N <= 1) {
    			return true;
    		}
    	}
    	return hayCamino(adyacentes.get(0), v2, N-1);
    }
    
    public List<List<Vertice<T>>> caminos(T v1, T v2){
    	return this.caminos(new Vertice<T>(v1), new Vertice<T>(v2));
    }
    
    public List<List<Vertice<T>>> caminos(Vertice<T> v1, Vertice<T> v2){
    	List<List<Vertice<T>>> salida = new ArrayList<List<Vertice<T>>>();
    	List<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
    	marcados.add(v1);
    	buscarCaminosAux(v1,v2,marcados,salida);
    	return salida;
    }
    
    private void buscarCaminosAux(Vertice<T> v1, Vertice<T> v2, List<Vertice<T>> marcados, List<List<Vertice<T>>> todos ) {
    	List<Vertice<T>> adyacentes = this.getAdyacentes(v1);
    	List<Vertice<T>> copiaMarcados = null;
    	for(Vertice<T> ady : adyacentes) {
    		copiaMarcados = marcados.stream()
    								.collect(Collectors.toList());
    		if(ady.equals(v2)) {
    			copiaMarcados.add(v2);
    			todos.add(new ArrayList<Vertice<T>>(copiaMarcados));
    		}
    		else {
    			if(!copiaMarcados.contains(ady)) {
    				copiaMarcados.add(ady);
    				this.buscarCaminosAux(ady, v2, copiaMarcados, todos);
    			}
    		}
    	}
    }
    
    public boolean esCompleto() {
    	for(Vertice<T> vertice : vertices) {
    		if(this.getAdyacentes(vertice).size() != (this.getVertices().size()-1)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public List<Vertice<T>> getVertices() {
    	return this.vertices;
    }
    
    /*
     * Escribir en la clase Grafo un m�todo que reciba como argumento un nodo N y un valor natural P, 
     * y devuelva  una lista con todos los nodos a los que se puede alcanzar desde el nodo N1 con  P transiciones. 
     * Asumir que el grafo no contiene ciclos.
     * */
    
    public List<Vertice<T>> funcion(Vertice<T> nodo, Integer p) {
    	List<Vertice<T>> resultado = new ArrayList<Vertice<T>>();
    	
    	if(p == 0) {
    		resultado.add(nodo);
    		return resultado;
    	}
    	if(p == 1) {
    		resultado.addAll(this.getAdyacentes(nodo));
    	}
    	if(p > 1) {
    		
    		for(Vertice<T> unNodo : this.getAdyacentes(nodo)) {
    			return funcion(unNodo, p-1);	
    		}
    		
    	}
    	return resultado;
    }
}
