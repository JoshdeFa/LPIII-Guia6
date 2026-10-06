package PedidoControlador;
import java.util.List;

import Pedido.Pedido;
import Pedido.PedidoModelo;
import PedidoVista.PedidoVista;

public class PedidoControlador {
	private PedidoModelo modelo;
	private PedidoVista vista;
	
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void agregarPedido(String nombrePlato, String tipo) {
		if(!nombrePlato.isEmpty()) {
			modelo.agregarPedido(new Pedido(nombrePlato, tipo));
			vista.mostrarMensaje("Pedido agregado: "+ nombrePlato);
		}else {
			vista.mostrarMensaje("Datos inválidos. No se agregó el pedido.");
		}
	}
	//Actividad3
	public void mostrarPendientes() {
		List<Pedido> pendientes = modelo.filtrarPorEstado("Pendiente", false);
		vista.mostrarPedidos(pendientes, "Pedidos Pendientes");
	}
	
	public void completarPedido(String nombre) {
		boolean completado = modelo.completarPedido(nombre);
		vista.mostrarMensaje(completado ? "Pedido completado!" : "No se encontro ningun pedido pendiente");
	}
	
	public void eliminarPedido(String nombre) {
		boolean eliminado= modelo.eliminarPedido(nombre);
		vista.mostrarMensaje(eliminado ? "Pedido cancelado" : "No se encontro ningun pedido");
	}
	
	public void mostrarHistorial() {
		vista.mostrarPedidos(modelo.getHistorial(), "Historial de pedidos");
	}
	
	public void mostrarContador() {
		vista.mostrarContador(modelo.contarPendientes());
	}
	
	public void iniciar() {
		String opcion;
		do {
            vista.mostrarMenu();
            opcion = vista.solicitarEntrada("Seleccione una opción: ");
            //Actividad2
            switch (opcion) {
            case "1":
                String nombre = vista.solicitarEntrada("Nombre del plato: ");
                String tipo = vista.solicitarEntrada("Tipo (Bebida, Plato Principal, etc.): ");
                agregarPedido(nombre, tipo);
                break;
            case "2":
                mostrarPendientes();
                break;
            case "3":
                String aCompletar = vista.solicitarEntrada("Nombre del plato a completar: ");
                completarPedido(aCompletar);
                break;
            case "4":
                String aEliminar = vista.solicitarEntrada("Nombre del plato a eliminar: ");
                eliminarPedido(aEliminar);
                break;
            case "5":
                mostrarHistorial();
                break;
            case "6":
                mostrarContador();
                break;
            case "7":
                vista.mostrarMensaje("Cerrando sistema...");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("7"));
		vista.cerrarScanner();
	}
}
