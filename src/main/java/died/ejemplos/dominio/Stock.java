package died.ejemplos.dominio;

public class Stock {
	
	private Insumo insumo;
	private Integer cantidad;
	private Integer minimo;
	
	
	//CONSTRUCTORES
	public Stock() {
		super();
	}
	public Stock(Insumo insumo, Integer cantidad, Integer minimo) {
		super();
		this.insumo = insumo;
		this.cantidad = cantidad;
		this.minimo = minimo;
	}
	
	//GETTERS Y SETTERS
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getMinimo() {
		return minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	@Override
	public String toString() {
		return "Stock [insumo=" + insumo + ", cantidad=" + cantidad + ", minimo=" + minimo + "]";
	}
	
	
	
}
