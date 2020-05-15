package lista;

public class Veiculo {
	private String cpf;
	private String placa;
	private String modelo;
	private int ano;
	private double valor;
	
	public Veiculo (String cpf, String placa, String modelo, int ano, double valor) {
		this.cpf = cpf;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
