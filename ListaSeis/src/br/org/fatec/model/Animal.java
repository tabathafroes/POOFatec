package br.org.fatec.model;

public class Animal {
	private String nome;
	private String raca;
	private char genero;
	private String idade;
	private int id_animal;
	
	public Animal(String nome, String raca, char genero, String idade, int id_animal) {
		this.setNome(nome);
		this.raca = raca;
		this.genero = genero;
		this.idade = idade;
		this.id_animal = id_animal;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public int getId_animal() {
		return id_animal;
	}

	public void setId_animal(int id_animal) {
		this.id_animal = id_animal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
