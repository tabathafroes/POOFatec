package br.org.fatec.model;

public class Atendimento {
	private String nomeP;
	private String nomeC;
	private String nomeA;
	private String cpfP;
	private String cpfC;
	private String data;
	
	public Atendimento(String nomeP, String nomeC, String nomeA, String cpfP, String cpfC, String data) {
		this.nomeP = nomeP;
		this.nomeC = nomeC;
		this.nomeA = nomeA;
		this.cpfP = cpfP;
		this.cpfC = cpfC;
		this.data = data;
	}

	public String getNomeP() {
		return nomeP;
	}

	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}

	public String getNomeC() {
		return nomeC;
	}

	public void setNomeC(String nomeC) {
		this.nomeC = nomeC;
	}

	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getCpfP() {
		return cpfP;
	}

	public void setCpfP(String cpfP) {
		this.cpfP = cpfP;
	}

	public String getCpfC() {
		return cpfC;
	}

	public void setCpfC(String cpfC) {
		this.cpfC = cpfC;
	}

	public String getHora() {
		return data;
	}

	public void setHora(String hora) {
		this.data = hora;
	}
	
}
