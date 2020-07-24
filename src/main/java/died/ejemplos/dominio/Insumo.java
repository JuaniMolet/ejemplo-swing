package died.ejemplos.dominio;

public class Insumo {

	private Integer id;
	private String descripcion;
	private Medida unidad;
	private Double costoUnitario;
	
	//CONSTRUCTORES
	public Insumo() {
		super();
	}
	public Insumo(Integer id, String descripcion, Medida unidad, Double costoUnitario) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.costoUnitario = costoUnitario;
	}


	//SETERS Y GETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Medida getUnidad() {
		return unidad;
	}
	public void setUnidad(Medida unidad) {
		this.unidad = unidad;
	}
	public Double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	@Override
	public String toString() {
		return "Insumo [id= " + id + ", descripcion= " +descripcion + ", unidad= " + unidad + ", costoUnitario= "
				+ costoUnitario + "]";
	}
	
	
	
	
}
