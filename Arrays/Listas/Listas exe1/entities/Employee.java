package entities;

public class Employee {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	// Construtores da classe
	
	public Employee () {
	}
	
	public Employee (int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	// Métodos getters and setters
	
	public int getId () {
		return this.id;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public double getSalario () {
		return this.salario;
	}
	
	public void setSalario (double salario) {
		this.salario = salario;
	}
	
	// Métodos da classe
	
	@Override
	public String toString () {
		return this.id + ", "
				+ this.nome + ", "
				+ String.format("$ %.2f", this.salario);
	}

}
