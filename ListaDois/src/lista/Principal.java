package lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		
		int op = 10;
		do {
			
			System.out.println("------------MENU------------");
			System.out.println("|1| - Cadastro de cliente");
			System.out.println("|2| - Cadastro de veiculo");
			System.out.println("|3| - Agendar revisão");
			System.out.println("|4| - Reagendar");
			System.out.println("|5| - Cancelar agendamento");
			System.out.println("|6| - Relatório de revisao");
			System.out.println("|0| - Sair");
			System.out.print("Digite uma opção: ");
			op = scanner.nextInt();
			
			switch(op) {
			case 1:							
					System.out.print("Nome: ");
					String nome = Texto();
					
					System.out.print("CPF: ");
					String cpf =  Texto();
					
					System.out.print("Telefone: ");
					String telefone =  Texto();
					
					System.out.print("Rua: ");
					String rua =  Texto();
					
					System.out.print("Numero: ");
					String numero =  Texto();
					
					System.out.print("Bairro: ");
					String bairro =  Texto();
					
					System.out.print("Cidade: ");
					String cidade =  Texto();
					
					System.out.print("Estado: ");
					String estado =  Texto();
					
					Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
					clientes.add(new Cliente(nome, endereco, telefone, cpf));
					break;
			case 2:
				System.out.print("CPF do dono: ");
				String cpfCliente =  Texto();
				
				System.out.print("Placa do veículo: ");
				String placa = Texto();
				
				System.out.print("Modelo do veículo: ");
				String modelo = Texto();
				
				System.out.print("Ano de fabricação: ");
				int ano = scanner.nextInt();
				
				System.out.print("Valor do veículo: ");
				double valor = scanner.nextDouble();
				
				veiculos.add(new Veiculo(cpfCliente, placa, modelo, ano, valor));	
				break;
			case 3:
				if (clientes.isEmpty() && veiculos.isEmpty()) {
					System.out.println("Cadastre um cliente e veiculo primeiro!");
				} else {
					System.out.println("CPF do dono do veiculo: ");
					String cpfAgendamento =  Texto();
					
					System.out.println("Placa do Veiculo: ");
					String placaVeiculo = Texto();
					
					System.out.println("Data do Agendamento");
					String data = Texto();
					
					System.out.println("Descrição da revisão:");
					String descricao = Texto();
					
					String cpfCheckerA = "";
					int idA = 0;
					for (idA = 0; idA <= clientes.size(); idA++) {
						cpfCheckerA = clientes.get(idA).getCpf();
						if (cpfCheckerA.equals(cpfAgendamento)) {
							break;
						}continue;
					}
					
					String placaCheckerA = "";
					int iA = 0;
					for (iA = 0; iA <= veiculos.size(); iA++) {
						placaCheckerA = veiculos.get(iA).getPlaca();
						if (placaCheckerA.equals(placaVeiculo)&& cpfCheckerA.equals(cpfAgendamento)) {
							break;
						}continue;
					}
					if (idA == iA) {
						agendamentos.add(new Agendamento(cpfAgendamento, placaVeiculo, data, descricao));
						System.out.println("Agendamento realizado com sucesso!!");
					}
				}					
				break;
				
			case 4:
				if (agendamentos.isEmpty()) {
					System.out.println("Ainda não existe agendamento, faça um!");
					
				}else {
					System.out.println("CPF do agendamento:");
					String cpfAgAnterior = Texto();
					
					System.out.println("Placa do veiculo do agendamento:");
					String placaAgAnterior = Texto();
					
					System.out.println("Nova data:");
					String novaData = Texto();
					
					String cpfChecker = "";
					int id = 0;
					for (id = 0; id <= agendamentos.size(); id++) {
						cpfChecker = agendamentos.get(id).getCpf();
						if (cpfChecker.equals(cpfAgAnterior)) {
							break;
						}continue;
					}
					
					String placaChecker = "";
					int i = 0;
					for (i = 0; i <= agendamentos.size(); i++) {
						placaChecker = agendamentos.get(i).getPlaca();
						if (placaChecker.equals(placaAgAnterior)) {
							break;
						}continue;
					}
					
					if (id == i) {
						agendamentos.get(id).setData(novaData);
						System.out.println("Reagendamento realizado com sucesso!!");
					}
				}
				break;					
				
			case 5:
				if (agendamentos.isEmpty()) {
					System.out.println("Ainda não existe agendamento, faça um!");
				} else {
					System.out.println("CPF do agendamento:");
					String cpfAgAnteriorC = Texto();
					
					System.out.println("Placa do veiculo do agendamento:");
					String placaAgAnteriorC = Texto();
					
					String cpfCheckerC = "";
					int idC = 0;
					for (idC = 0; idC <= agendamentos.size(); idC++) {
						cpfCheckerC = agendamentos.get(idC).getCpf();
						if (cpfCheckerC.equals(cpfAgAnteriorC)) {
							break;
						}continue;
					}
					
					String placaCheckerC = "";
					int iC = 0;
					for (iC = 0; iC <= agendamentos.size(); iC++) {
						placaCheckerC = agendamentos.get(iC).getPlaca();
						if (placaCheckerC.equals(placaAgAnteriorC)) {
							break;
						}continue;
					}
					
					if (idC == iC) {
						agendamentos.remove(idC);
						System.out.println("Cancelamento realizado com sucesso!!");
					}
				}
				break;
				
			case 6:
				if(agendamentos.isEmpty()) {
					System.out.println("Não existe revisões cadastradas!");
					
				}else {
					System.out.println("\nLista de revisões:\n");
					
					Agendamento a;
					for(int x = 0; x < agendamentos.size(); x++) {
						a = agendamentos.get(x);
						System.out.println("CPF: "+a.getCpf()+"\n");
						System.out.println("Veiculo: "+a.getPlaca()+"\n");
						System.out.println("Data: "+a.getData()+"\n");
						System.out.println("Descrição: "+a.getDescricao()+"\n");
					}			
				}
				break;
				
			case 0:
				System.exit(0);
			default:
				System.out.println("Opção inexistente, tente novamente \n\n\n");
				System.out.println("------------MENU------------");
				System.out.println("|1| - Cadastro de cliente");
				System.out.println("|2| - Cadastro de veiculo");
				System.out.println("|3| - Agendar revisão");
				System.out.println("|4| - Reagendar");
				System.out.println("|5| - Cancelar agendamento");
				System.out.println("|6| - Relatório de revisao");
				System.out.println("|0| - Sair");
				System.out.print("Digite uma opção: ");
				op = scanner.nextInt();
			
			}
			
		}while(op != -1);


	}

	private static String Texto() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
}
