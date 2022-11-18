package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	
	private String name;
	private String email;
	private LocalDate birthday;
	
	// Formatações de data
	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Construtores da classe
	public Client () {}
	
	public Client (String clientName, String clientEmail, LocalDate clientBirthday) {
		name = clientName;
		email = clientEmail;
		birthday = clientBirthday;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	// Métodos da classe
	public String toString () {
		StringBuilder almost = new StringBuilder ();
		almost.append(name + " " + birthday.format(fmt1) + " - " + email);
		return almost.toString();
	}

}
