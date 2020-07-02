package br.org.fatec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.org.fatec.model.*;

public class Controle {
	public static Scanner scanner;
	List<Profissional> profissionais = new ArrayList<Profissional>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Animal> animais = new ArrayList<Animal>();
	List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	List<RelatorioRaca> relatorios = new ArrayList<RelatorioRaca>();
		
	
	public Controle(){
		Controle.scanner = new Scanner(System.in); 
	}
	
	public int escolha() {
		return scanner.nextInt();
	}
	
	public String texto() {
		return scanner.nextLine();
	}
	
	public void cadastrarProfissional() {
		System.out.println("Digite os dados do profissional");
		System.out.println("Nome:");
		String nomeP = texto();
		if (nomeP.isEmpty()) {
			nomeP = texto();
		}
		System.out.println("CPF (somente números):");
		String cpfP = texto();		
		if(cpfP.length() != 11) {
			System.out.println("CPF inválido, digite novamente:");
			cpfP = texto();
		}
		
		System.out.println("Rua:");
		String ruaP = texto();
		System.out.println("Número:");
		String numP = texto();
		System.out.println("Bairro:");
		String bairroP = texto();
		System.out.println("Cidade:");
		String cidadeP = texto();
		System.out.println("Estado (somente a sigla):");
		String estadoP = texto();
		if (estadoP.length() != 2){
			System.out.println("Estado inválido, digite novamente:");
			estadoP = texto();
		}
		System.out.println("CEP (somente números):");
		String cepP = texto();
		if(cepP.length() != 8) {
			System.out.println("CEP inválido, digite novamente:");
			estadoP = texto();
		}
		Endereco end = new Endereco(ruaP, numP, bairroP, cidadeP, estadoP, cepP);
		
		System.out.println("Telefone: (DDD+Número)");
		String telP = texto();
		if(telP.length() == 11 || telP.length() == 10) {
				
		}else {
			System.out.println("Número inválido, digite novamente:");
			telP = texto();
		}
		Profissional p = new Profissional(nomeP, cpfP, end, telP);		
		profissionais.add(p);
		System.out.println("Profissional cadastrado!");	
			
	}
		
	public void cadastrarCliente() {
		System.out.println("Digite os dados do cliente");
		System.out.println("Nome:");
		String nomeC = texto();
		if (nomeC.isEmpty()) {
			nomeC = texto();
		}
		System.out.println("CPF (somente números):");
		String cpfC = texto();		
		if(cpfC.length() != 11) {
			System.out.println("CPF inválido, digite novamente:");
			cpfC = texto();
		}
		
		System.out.println("Rua:");
		String ruaC = texto();
		System.out.println("Número:");
		String numC = texto();
		System.out.println("Bairro:");
		String bairroC = texto();
		System.out.println("Cidade:");
		String cidadeC = texto();
		System.out.println("Estado (somente a sigla):");
		String estadoC = texto();
		if (estadoC.length() != 2){
			System.out.println("Estado inválido, digite novamente:");
			estadoC = texto();
		}
		System.out.println("CEP (somente números):");
		String cepC = texto();
		if(cepC.length() != 8) {
			System.out.println("CEP inválido, digite novamente:");
			estadoC = texto();
		}
		Endereco end = new Endereco(ruaC, numC, bairroC, cidadeC, estadoC, cepC);
		
		System.out.println("Telefone: (DDD+Número)");
		String telC = texto();
		if(telC.length() == 11 || telC.length() == 10) {
				
		}else {
			System.out.println("Número inválido, digite novamente:");
			telC = texto();
		}
		
		boolean outroAnimal = true;
		int cont = 0;
		do{
			System.out.println("Digite os dados do animal");
			System.out.println("Nome:");
			String nomeA = texto();
			
			System.out.println("Raça:");
			String racaA = texto();
			
			System.out.println("Idade (somente números):");
			String idadeA = texto();
					
			System.out.println("Genêro: (F ou M)");
	        String genero = texto();
	        char generoA = genero.charAt(0);
	        while(generoA!='F' && generoA!='M') {
	        	System.out.println("Gênero inválido, digite novamente:");
	        	genero = texto();
		        generoA = genero.charAt(0);
	        }
			
			Animal a = new Animal(nomeA, racaA, generoA, idadeA, cont);
			animais.add(a);
			
			System.out.println("Gostaria de cadastrar outro animal ? (S ou N) ");
			String confirmacao = texto();
			char confirma = confirmacao.charAt(0);			
			outroAnimal = (confirma == 'S') ? true : false;
			cont++;
			
		 }while(outroAnimal && cont < 5);
		
		Cliente c = new Cliente(nomeC, cpfC, end, telC, animais);		
		clientes.add(c);
		System.out.println("Cliente cadastrado!");	
			
	}
		
	public void novoAtendimento() {
		Cliente cli = null;
		
		
		System.out.println("Digite os dados do cliente a ser atendido");
		System.out.println("Nome:");
		String nomeC = texto();
		if (nomeC.isEmpty()) {
			nomeC = texto();
		}
		System.out.println("CPF (somente números):");
		String cpfC = texto();		
		if(cpfC.length() != 11) {
			System.out.println("CPF inválido, digite novamente:");
			cpfC = texto();
		}
		for (Cliente c : clientes) {
			if(c.getCpf() == cpfC) {
				cli =  c;
				break;
			} 
		}
		System.out.println("Nome do animal:");
		String nomeA = texto();
		for (Animal a : cli.getAnimais()) {
			if(a.getNome().toLowerCase() == nomeA.toLowerCase()) {
			
			}else{
				System.out.println("Não existe animal cadastrado para esse nome.");
			}
		}
		System.out.println("Digite os dados do atendente:");
		System.out.println("Nome:");
		String nomeP = texto();
		if (nomeP.isEmpty()) {
			nomeP = texto();
		}
		System.out.println("CPF (somente números):");
		String cpfP = texto();
		if(cpfC.length() != 11) {
			System.out.println("CPF inválido, digite novamente:");
			cpfC = texto();
		}
		for (Profissional p : profissionais) {
			if(p.getCpf() == cpfP) {
				break;
			} System.out.println("Não existe profissional cadastrado para esse cpf");
		}
		System.out.println("Digite a data do agendamento:");
		String dataA = texto();
		
		Atendimento atd = new Atendimento(nomeP, nomeC, nomeA, cpfP, cpfC, dataA);
		atendimentos.add(atd);
		System.out.println("Atendimento realizado com sucesso!");
		
	}
		
	public void relatorioRaca() {
		for (Animal a : animais) {
			if (relatorios.isEmpty()) {
				String raca = a.getRaca();
				int qnt = 1;
				RelatorioRaca r = new RelatorioRaca(raca, qnt);
				relatorios.add(r);
			}else if(relatorios.size() > 0) {
				for(RelatorioRaca n : relatorios) {
					if (n.getRaca().toLowerCase() == a.getRaca().toLowerCase()) {
						int quantidade = n.getQuantidade();
						n.setQuantidade(quantidade+1);
					}else {
						String raca = a.getRaca();
						int qnt = 1;
						RelatorioRaca r = new RelatorioRaca(raca, qnt);
						relatorios.add(r);
					}
				}
			}
		}
		for(int i = 0; i < relatorios.size(); i++) {
			for (RelatorioRaca n: relatorios) {
				int maior = 0;
				if (n.getQuantidade() >= maior) {
					maior = n.getQuantidade();
					System.out.println((i+1)+"°-"+n.getRaca()+"("+maior+")");
					relatorios.remove(n);
				}
			}
		}
	}
	
		
	public void relatorioGenero() {
			int masculino = 0;
			int feminino = 0;
			for (Animal a : animais) {
				if(a.getGenero() == 'M') {
					masculino++;
					
				}else {
					feminino++;
				}
			if (masculino > feminino) {
				System.out.println("Os animais em sua maioria são machos!");
			}else if (feminino > masculino) {
				System.out.println("Os animais em sua maioria são fêmeas!");
			}else {
				System.out.println("Que beleza! Temos números iguais de fêmeas e machos!");
			}
			}
	}
	
	public void historicoAtendimento() {
		for (int i = 0; i < atendimentos.size(); i++) {
			System.out.println("Atendimento "+(i+1)+":");
			System.out.println(atendimentos.get(i).getNomeC());
			System.out.println(atendimentos.get(i).getCpfC());
			System.out.println(atendimentos.get(i).getNomeA());
			System.out.println(atendimentos.get(i).getNomeP());
			System.out.println(atendimentos.get(i).getCpfP());
			System.out.println(atendimentos.get(i).getHora());
		}
	}
	
}
