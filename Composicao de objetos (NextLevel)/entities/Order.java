package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

// PEDIDO
public class Order {
	
	// Atributos da classe 
	private LocalDateTime moment;
	private OrderStatus status;
	
	// Atributos de associação
	private Client client;
	List <OrderItem> item = new ArrayList <>(); // Itens que o pedido irá conter
	
	// Formatações de datas
	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	// Construtores da classe
	public Order () {}
	
	public Order(Client client, OrderStatus status) {
		this.moment = LocalDateTime.now(); // Momento em que o pedido é processado
		this.status = status;
		this.client = client;
	}

	// Métodos getters and setters
	public List <OrderItem> getItem () {
		return item;
	}
	
	public LocalDateTime getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	// Métodos da classe
	public void addItem (OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem (OrderItem item) {
		this.item.remove(item);
	}
	
	// Representação da nota do pedido
	public String toString () {
		StringBuilder almost = new StringBuilder ();
		almost.append(
				"Momento do pedido: " + moment.format(fmt1)
				+ "\nStatus do pedido: " + status
				+ "\nCliente: " + client.toString()
				+ "\nItens do pedido: \n");
		for (OrderItem item : item) {
			almost.append(item.toString() + "\n");
		}
		return almost.toString();
	}

}
