package br.org.fatec.model;

public class RelatorioRaca {
	private String raca;
	
	public RelatorioRaca(String raca, int quantidade) {
		this.raca = raca;
		this.quantidade = quantidade;	
	}
	private int quantidade;
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
