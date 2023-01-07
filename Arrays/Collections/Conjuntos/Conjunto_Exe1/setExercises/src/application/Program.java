package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.TreeSet;

import entities.Product;
import entities.Products;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Product p1 = new Product("Geladeira", 1000.00);
		Product p2 = new Product("Geladeira", 1000.03);
		Product p3 = new Product("Moto", 1000.02);
		Product p4 = new Product("Liquidificador", 1000.01);
		Product p5 = new Product("Microondas", 1000.04);

		Products products = new Products(new ArrayList<>());
		
		products.addProducts(p1);
		products.addProducts(p2);
		products.addProducts(p3);
		products.addProducts(p4);
		products.addProducts(p5);
		
		products.printList();
		
		System.out.println("\n-----------------TREE SET-------------------\n");
		
		products.changeCollection(new TreeSet<>());
		products.printList();
		
		System.out.println("\n------------------LINKED HASH SET------------------\n");
		
		products.changeCollection(new LinkedHashSet<>());
		products.printList();
		
		System.out.println("\n----------------HASH SET--------------------\n");
		
		products.changeCollection(new HashSet<>());
		products.printList();
		
	}

}
