package died.ejemplos.dominio;

public class InsumoGeneral extends Insumo{
	
	private Double peso;
	
	//CONSTRUCTORES.
	public InsumoGeneral(Double peso) {
		super();
		this.peso = peso; 
	}
	public InsumoGeneral(Integer id, String desc, Medida unidad, Double costo, Double peso) {
		super.setId(id);
		super.setDescripcion(desc);
		super.setUnidad(unidad);
		super.setCostoUnitario(costo);
		this.peso = peso;
	}
	
	//GETTER Y SETTER
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	//METODOS
	public Double pesoPorUnidad(){
		switch (this.getUnidad()) {
		case KILO:
			return peso;
		case GRAMO:
			return peso*1000;
		default:
			return 0.0;
	}
	}
	@Override
	public String toString() {
		return "InsumoGeneral [id= " + this.getId() + ", descripcion= " + this.getDescripcion() + ", unidad= " + this.getUnidad() + ", costoUnitario= "
				+ this.getCostoUnitario() + ", peso= " + this.peso + "]";
	}
	
	
	
}
