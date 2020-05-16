package lista;


public class Pessoa {
    private String nome;
    private String genero;
    private String telefone;
    private String dataNascimento;

    
    public Pessoa(String nome, String genero, String telefone, String dataNascimento) {
        this.nome = nome;
        this.genero = genero;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;

    }

    public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
        return this.nome;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String toString() {
        return "Nome: " +nome + ", Genêro: " +genero + ", Data de nascimento: " +dataNascimento + ", Telefone: " +telefone;
    }

}