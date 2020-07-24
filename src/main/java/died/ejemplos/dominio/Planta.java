package died.ejemplos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Grafos.Vertice;

public class Planta extends Vertice<Planta>{

	private Integer id;
	private String nombre;
	private List<Stock> listaStock;
	private List<Insumo> insumos;
	private List<Camion> camiones;
	private List<Ruta> rutas;
	
	//CONSTRUCTOR 
	public Planta() {
		super.setValor(this);
		this.listaStock = new ArrayList<Stock>();
		this.insumos = new ArrayList<Insumo>();
		this.camiones = new ArrayList<Camion>();
	}
	public Planta(Integer id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}
	
	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Stock> getListaStock() {
		return listaStock;
	}
	public void setListaStock(List<Stock> listaStock) {
		this.listaStock = listaStock;
	}
	public List<Insumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}
	public List<Camion> getCamiones() {
		return camiones;
	}
	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}
	
	@Override
	public String toString() {
		return "Planta [id=" + id + ", nombre=" + nombre + ", listaStock=" + listaStock + ", insumos=" + insumos
				+ ", camiones=" + camiones + "]";
	}
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 19 * hash + Objects.hashCode(this.id);
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Planta otra = (Planta) obj;
		if(id == null) {
			if(otra.id != null) {
				return false;
			}
		} else if(!id.equals(otra.nombre)){
			return false;
		}
		return true;
	}
	
	
	
}
