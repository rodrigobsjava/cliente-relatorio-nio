package main.java.com.rodrigobsjava.cliente.model;

public class Cliente {
	private String nome;
	private String email;
	private int idade;

	public Cliente(String nome, String email, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}

	public String formatado() {
		return String.format("Nome: %s | Email: %s | Idade: %d", nome, email, idade);
	}

}
