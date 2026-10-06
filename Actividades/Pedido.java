package Pedido;

public class Pedido {
	private String nombrePlato;
	private String tipo;//Actividad2
	private String estado; //pendiente, Completo, eliminado, Actividad3
	
	public Pedido(String nombrePlato, String tipo) {
		this.nombrePlato = nombrePlato;
		this.tipo = tipo;
		this.estado = "Pendiente"; //Actividad3
	}
	//Actividad2
	public String getNombrePlato() {
		return nombrePlato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//Actividad3
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
