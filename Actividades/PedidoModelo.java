package Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
	//Actividad3
	private List<Pedido> pedidosActivos;
	private List<Pedido> historialPedidos;
	
	public PedidoModelo() {
		pedidosActivos= new ArrayList<>();
		historialPedidos = new ArrayList<>();
	}
	//Actividad3
	public void agregarPedido(Pedido pedido) {
		pedidosActivos.add(pedido);
	}
	public List<Pedido> getPedidos() {
        return pedidosActivos;
    }
	
	public List<Pedido> getPedidosActivos(){
		return pedidosActivos;
	}
	
	public List<Pedido> getHistorial(){
		return historialPedidos;
	}
	public boolean completarPedido(String nombre) {
		for(int i = 0; i < pedidosActivos.size(); i++) {
			Pedido p = pedidosActivos.get(i);
			if(p.getNombrePlato().equalsIgnoreCase(nombre)) {
				p.setEstado("Completado");
				historialPedidos.add(p);
				pedidosActivos.remove(i);
				return true;
			}
		}
		return false;
	}
	//Actividad3
	public boolean eliminarPedido(String nombre) {
		for (int i = 0; i < pedidosActivos.size(); i++) {
            Pedido p = pedidosActivos.get(i);
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado("Eliminado");
                historialPedidos.add(p);
                pedidosActivos.remove(i);
                return true;
            }
        }
        return false;
    }
	
	public List<Pedido> filtrarPorEstado(String estado, boolean buscarEnHistorial){
		List<Pedido> resultados = new ArrayList<>();
		List<Pedido> listaObjetivo = buscarEnHistorial ? historialPedidos : pedidosActivos;
		
		for(Pedido p : listaObjetivo) {
			if(p.getEstado().equalsIgnoreCase(estado)) {
				resultados.add(p);
			}
		}
		return resultados;
	}
	
	public int contarPendientes() {
		int contador = 0;
		for(Pedido  p : pedidosActivos) {
			if(p.getEstado().equalsIgnoreCase("Pendiente")) {
				contador++;
			}
		}
		return contador;
	}

    public boolean actualizarPedido(String nombreAntiguo, String nombreNuevo) {
        for (Pedido p : pedidosActivos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreAntiguo)) {
                p.setNombrePlato(nombreNuevo);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarPedido(String criterio) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido p : pedidosActivos) {
            if (p.getNombrePlato().equalsIgnoreCase(criterio) || p.getTipo().equalsIgnoreCase(criterio)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public int contarPedidosTotales() {
        return pedidosActivos.size();
    }

    public int contarPedidosPorTipo(String tipo) {
        int contador = 0;
        for (Pedido p : pedidosActivos) {
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}