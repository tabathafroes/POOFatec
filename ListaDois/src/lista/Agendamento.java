package lista;

public class Agendamento {
	private String cpf;
	private String placa;
	private String data;
	private String descricao;
	
	public Agendamento(String cpf, String placa, String data, String descricao) {
		this.cpf = cpf;
		this.placa = placa;
		this.data =  data;
		this.descricao = descricao;

	}
	
	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
}
