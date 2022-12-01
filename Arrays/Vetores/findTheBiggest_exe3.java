import java.util.Scanner;
import java.util.Locale;


public class findTheBiggest {
	
	/* Escreva um programa Java para encontrar o maior elemento
	   entre os valores primeiro, último e intermediário de uma
	   matriz de inteiros (comprimento par). */

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		 int[] array_nums = {20, 30, 40, 50, 67};
		 
		 System.out.println("O maior é: " + moreBiggest(array_nums));
		
		sc.close();

	}
	
	public static int moreBiggest (int[] array_nums) {
		int maior;
		
		if (array_nums[0] > array_nums[array_nums.length/2]) maior = array_nums[0];
		else if (array_nums[array_nums.length/2] > array_nums[array_nums.length - 1]) maior = array_nums[array_nums.length/2];
		else maior = array_nums[array_nums.length - 1];
		
		return maior;
	}

}
