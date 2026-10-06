package PedidoVista;
import java.util.List;
import java.util.Scanner;

import Pedido.Pedido;

public class PedidoVista {
	private Scanner sc;
	
	public PedidoVista() {
		sc = new Scanner(System.in);
	}
	
	public String solicitarNombrePlato() {
		System.out.println("Introduce el nombre del plato: ");
		return sc.nextLine();
	}
	//Activdad2
	public String solicitarEntrada(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public void mostrarPedidos(List<Pedido> pedidos, String titulo) {
		System.out.println("\n-- " + titulo + " --");
		if(pedidos.isEmpty()) {
			System.out.println("No hay pedidos.");
		}else {
			System.out.println("Lista de pedidos: ");
			for(Pedido pedido : pedidos) {
				//Actividad2
				System.out.println("- [" + pedido.getEstado()+ "] " + " [ "+ pedido.getTipo()+ "] " + pedido.getNombrePlato());
			}
		}
	}
	//Actividad3
	public void mostrarContador(int cantidad) {
		System.out.println("\n Tienes "+ cantidad + " pedido(s) pendiente(s) en la cola");
	}
	
	//Actividad2
	public void mnostrarConteo(int total, String tipo, int cantidadTipo) {
		System.out.println("Total de pedidos: " + total);
		if(tipo != null && !tipo.isEmpty()) {
			System.out.println("Pedidos de tipo '" + tipo + "' " + cantidadTipo);
		}
	}
	
	public void mostrarMenu() {
		System.out.println("\n======Menu======");
		System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos Pendientes");
        System.out.println("3. Marcar Pedido como Completado");
        System.out.println("4. Eliminar Pedido");
        System.out.println("5. Ver Historial (Completados/Eliminados)");
        System.out.println("6. Mostrar Contador de Pendientes");
        System.out.println("7. Salir");
	}
	
	public String solicitarOpcion() {
		System.out.println("Seleccione una opcion: ");
		return sc.nextLine();
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void cerrarScanner() {
		sc.close();
	}
}
