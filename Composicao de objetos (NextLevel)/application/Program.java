package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		// Ler os dados de um pedido com N itens. Depois, mostrar um sumário do pedido.
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Inserindo informações para o objeto cliente
		System.out.println("Insira os dados do cliente: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		
		System.out.print("Birth Date: ");
		LocalDate clientBirthday = LocalDate.parse(sc.next(), fmt1);
		
		// Inserindo informações para o objeto pedido
		System.out.println("Insira os dados do pedido: ");
	
		sc.nextLine();
		
		// Informando o status do pedido
		System.out.print("Status(PAGAMENTO_PENDENTE/PROCESSANDO/ENVIADO/ENTREGUE): ");
		String status = sc.nextLine().toUpperCase();
		
		System.out.println("Quantos itens deseja adicionar à esse pedido?");
		int n = sc.nextInt();
		
		// Instância de um objeto cliente (Client) e status do pedido (OrderStatus) dentro do objeto pedido (Order)
		Order pedido = new Order (new Client(clientName, clientEmail, clientBirthday), OrderStatus.valueOf(status));
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Insira os dados do item #" + i);
			
			System.out.print("Nome do produto: ");
			String productName = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			int productQuantity = sc.nextInt();
			
			// Criando objeto de item do pedido (orderItem) e instanciando objeto produto (Product) dentro desse item
			OrderItem item = new OrderItem(productQuantity, new Product(productName, productPrice));
			
			// Adicionando o item à lista que fica dentro do objeto pedido (Order)
			pedido.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("SUMÁRIO DO PEDIDO: ");
		System.out.println(pedido.toString());
		
		sc.close();

	}

}
