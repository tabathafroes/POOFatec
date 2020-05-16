package lista;

import java.util.*;

public class Principal {

	
    private static Scanner scanner;
   
    public static void main(final String[] args) {
    	scanner = new Scanner(System.in);
    	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    	ArrayList<String> listaAlfabetica = new ArrayList<String>();
    	
    	  int op = 0;
          do {
        	  System.out.println("------------------MENU------------------");
  			System.out.println("|1| - Cadastro de cliente");
  			System.out.println("|2| - Editar cadastro");
  			System.out.println("|3| - Remover cadastro");
  			System.out.println("|4| - Listar clientes de A-Z");
  			System.out.println("|5| - Listar clientes por genero de A-Z");
  			System.out.println("|6| - Listar Serviços realizados");
  			System.out.println("|7| - Relatórios");
  			System.out.println("|0| - Sair");
  			System.out.print("Digite uma opção: ");
  			op = scanner.nextInt();


              switch (op) {
              case 1:
            	  System.out.println("Nome: ");
            	  String nome = Texto();
            	  
            	  System.out.println("Genero (Masculino/Feminino/Outro): ");
            	  String genero = Texto();
            	  
            	  System.out.println("Telefone: ");
            	  String telefone = Texto();
            	  
            	  System.out.println("Data de Nascimento: ");
            	  String dataNascimento = Texto();
            	  
            	  pessoas.add(new Pessoa(nome, telefone, genero, dataNascimento));
            	  System.out.println("Cadastro realizado com sucesso!");
                  break;
              case 2:
            	  System.out.println("Digite o nome do cadastro que quer alterar");
            	  String nomeCadastrado = Texto();            	  

            	  String nomeChecker = "";
            	  int id = 0;
            	  for (id = 0; id < pessoas.size(); id++){
            	  	nomeChecker = pessoas.get(id).getNome();
            	  	if (nomeChecker.equals(nomeCadastrado)){
            	  		System.out.println("Novo Nome: ");
            	  		String nomeE = Texto();
                  	  
            	  		System.out.println("Novo Genero (Masculino/Feminino/Outro): ");
            	  		String generoE = Texto();
                  	  
            	  		System.out.println("Novo Telefone: ");
            	  		String telefoneE = Texto();
                  	  
            	  		System.out.println("Nova Data de Nascimento: ");
            	  		String dataNascimentoE = Texto();
            	  		
            	  		pessoas.get(id).setNome(nomeE);
            	  		pessoas.get(id).setGenero(generoE);
            	  		pessoas.get(id).setTelefone(telefoneE);
            	  		pessoas.get(id).setDataNascimento(dataNascimentoE);
            	  		
            	  	}else {
            	  		System.out.println("Não encontramos seu cadastro!");
            	  	}
            	  }
            	  break;
              case 3:
            	  if (pessoas.isEmpty()) {
  					System.out.println("Ainda não existe cadastros, faça um!");
  					} else {
  					System.out.println("Digite o nome do cadastro que quer alterar");
  					String nomeCancelar = Texto();
  					
  					String nomeCheckerC = "";
  					int idC = 0;
  					for (idC = 0; idC <= pessoas.size(); idC++) {
  						nomeCheckerC = pessoas.get(idC).getNome();
  						if (nomeCheckerC.equals(nomeCancelar)) {
  							pessoas.remove(idC);
  							System.out.println("Remoção realizada com sucesso!!");
  						}else {
  	            	  		System.out.println("Não encontramos seu cadastro!");
  	            	  	}
  					}
  					}
                  break;
              case 4:
            	  for(Pessoa p : pessoas) {
            		    listaAlfabetica.add(p.getNome());
            		}

            		Collections.sort(listaAlfabetica);
            		System.out.println("Clientes por ordem alfabetica:");
            		if(listaAlfabetica.isEmpty()) {
            			System.out.println("Cadastre-se primeiro!");
            		}else {
            			for (int j = 0; j < listaAlfabetica.size(); j++) {
                			System.out.println(listaAlfabetica.get(j));
                		}       
            		}
            		break;
            		
              case 5:
            	  break;
              case 6:
            	  break;
              case 7:
            	  break;
              case 0:
            	  System.exit(0);
              default:
                  break;
              }
          } while (op != -1);
    }
    
	private static String Texto() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}