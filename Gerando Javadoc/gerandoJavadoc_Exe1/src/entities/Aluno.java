package entities;

/**
 * Aluno.
 * @author marcos
 * @version 1.0
 */
public class Aluno {

	/**
	 * Nome do aluno.
	 */
	private String nome;
	/**
	 * Média do aluno.
	 */
	private Double media;
	
	/**
	 * Construtor padrão.
	 */
	public Aluno () {
	}
	
	/**
	 * Construtor.
	 * @param nome Nome do aluno.
	 */
	public Aluno (String nome) {
		this.nome = nome;
		this.media = 0.0;
	}
	
	/**
	 * Retorna o nome do aluno.
	 * @return Nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do aluno.
	 * @param nome Nome do aluno.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a média do aluno.
	 * @return Média do aluno.
	 */
	public Double getMedia() {
		return media;
	}

	/**
	 * Altera a média do aluno.
	 * @param media Média do aluno.
	 */
	public void setMedia(Double media) {
		this.media = media;
	}
	
	/**
	 * Calcula a média do aluno.
	 * @param sum Soma das notas do aluno.
	 * @param quantNotas Quantidade de notas que o aluno teve
	 */
	public void mediaAluno (double sum, int quantNotas) {
		this.media = sum / quantNotas;
		System.out.println("Sua média é: " + this.media);
	}

}
