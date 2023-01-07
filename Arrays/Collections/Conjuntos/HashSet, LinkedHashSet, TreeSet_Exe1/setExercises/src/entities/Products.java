package entities;

import java.util.Collection;

public class Products {
	
	private Collection<Product> productList;
	
	public Products() {
	}

	public Products(Collection<Product> productList) {
		this.productList = productList;
	}

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}
	
	/**
	 * Adiciona produtos à lista.
	 * @param product Produto a ser adicionado.
	 */
	public void addProducts(Product product) {
		productList.add(product);
	}
	
	public void printList() {
		for (Product product : productList) {
			System.out.println(product + " | HashCode: " + product.hashCode());
		}
	}
	
	public void changeCollection(Collection<Product> other) {
		other.addAll(this.productList);
		this.productList = other;
	}

}
