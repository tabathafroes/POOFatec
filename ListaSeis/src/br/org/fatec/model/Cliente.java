package br.org.fatec.model;

import java.util.List;

public class Cliente extends Pessoa {

	public List <Animal> animais;
	
	public Cliente(String nome, String cpf, Endereco endereco, String telefone, List<Animal> animais) {
		super(nome, cpf, endereco, telefone);
		this.animais = animais;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	
}
