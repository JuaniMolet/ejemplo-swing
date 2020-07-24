package Grafos;

import java.util.Objects;

public class Arista<T> {

	private Vertice<T> inicio;
	private Vertice<T> fin;
	private Number valor;
	
	//CONSTRUCTORES.
	public Arista() { valor = 0.0; } 
	
	public Arista(Vertice<T> ini, Vertice<T> fin) {
		this();
		this.inicio = ini;
		this.fin = fin;
	}
	
	public Arista(Vertice<T> ini, Vertice<T> fin, Number val) {
		this(ini, fin);
		this.valor = val;
	}

	//METODOS
	public Vertice<T> getInicio() {
		return inicio;
	}

	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}

	public Vertice<T> getFin() {
		return fin;
	}

	public void setFin(Vertice<T> fin) {
		this.fin = fin;
	}

	public Number getValor() {
		return valor;
	}

	public void setValor(Number valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fin, inicio, valor);
	}
	
	@Override
	public String toString() {
		return "( "+this.inicio.getValor()+" --> "+this.fin.getValor()+" )";
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Arista<?>) && ((Arista<?>)obj).getValor().equals(this.valor); 
	}
	
	
}
