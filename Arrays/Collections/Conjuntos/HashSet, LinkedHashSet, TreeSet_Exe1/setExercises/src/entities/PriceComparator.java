package entities;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if (o1.getPrice() == (o2.getPrice())) {
			return 0;
		}
		
		if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
			return 1;
		}
		
		return -1;
	}

}
