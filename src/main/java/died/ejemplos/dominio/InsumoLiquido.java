package died.ejemplos.dominio;

public class InsumoLiquido extends Insumo {
 
	private Double densidad;
	
	//CONSTRUCTORES.
	public InsumoLiquido(Double densidad) {
		super();
		this.densidad = densidad; 
	}
	public InsumoLiquido(Integer id, String desc, Medida unidad, Double costo, Double densidad) {
		super.setId(id);
		super.setDescripcion(desc);
		super.setUnidad(unidad);
		super.setCostoUnitario(costo);
		this.densidad = densidad;
	}
	
	//GETTER Y SETTER
	public Double getDensidad() {
		return densidad;
	}
	public void setDensidad(Double densidad) {
		this.densidad = densidad;
	}
	
	public Double pesoPorUnidad() {
		switch (this.getUnidad()) {
			case LITRO:
				return 0.001*this.densidad;
			case MILILITRO:
				return 0.001*this.densidad*0.001;
			default:
				return 0.0;
		}
	}
	
	@Override
	public String toString() {
		return "InsumoLiquido [id= " + this.getId() + ", descripcion= " + this.getDescripcion() + ", unidad= " + this.getUnidad() +
				", costoUnitario= " + this.getCostoUnitario() + ", peso= " + this.densidad + "]";
	}
	
	
	
}
