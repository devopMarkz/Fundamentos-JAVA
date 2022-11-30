package entities;

public class Pessoa {
	
	private String name;
	private Integer age;
	
	// Construtores da classe
	
	public Pessoa () {
		
	}
	
	public Pessoa(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
