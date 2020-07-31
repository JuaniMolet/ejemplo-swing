package died.ejemplos.dominio;

import java.time.LocalTime;

import Grafos.Arista;
import Grafos.Vertice;

public class Ruta extends Arista<Planta>{

	private Integer numero;
	private Double distancia;
	private Double horas;

	
	//CONSTRUCTORES.
	public Ruta(Integer numero) {
		super();
		this.numero = numero;
	}
	public Ruta(Integer numero, Planta origen, Planta destino, Double distancia, Double horas, Double pesoMaximo) {
		super(origen, destino, pesoMaximo);
		this.numero = numero;
		this.distancia = distancia;
		this.horas = horas;
	}
	
	//GETTERS Y SETTERS
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Planta getOrigen() {
		return super.getInicio().getValor();
	}
	
	public void setOrigen(Planta origen) {
		super.setInicio(origen);
	}
	
	public Planta getDestino() {
		return super.getFin().getValor();
	}
	public void setDestino(Planta destino) {
		super.setFin(destino);
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getHoras() {
		return horas;
	}
	public void setHoras(Double horas) {
		this.horas = horas;
	}
	public Double getPesoMaximo() {
		return (Double) super.getValor();
	}
	public void setPesoMaximo(Double pesoMaximo) {
		super.setValor((Double)pesoMaximo);
	}
	
	@Override
	public String toString() {
		return "Ruta [numero=" + numero + ", origen=" + this.getInicio() + ", destino=" + this.getFin() + ", distancia=" + distancia
				+ ", horas=" + horas + ", pesoMaximo=" + this.getPesoMaximo() + "]";
	}
	
	
	
}
