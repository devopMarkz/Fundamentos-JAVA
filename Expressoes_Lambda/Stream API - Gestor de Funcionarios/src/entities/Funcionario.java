package entities;

public class Funcionario {
	
	private String nome;
	private String email;
	private Double salario;
	
	// CONSTRUTORES DA CLASSE
	
	public Funcionario(String nome, String email, Double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", email=" + email + ", salario=" + salario + "]";
	}

	
	
}
