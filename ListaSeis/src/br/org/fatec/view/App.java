package br.org.fatec.view;


import br.org.fatec.controller.*;

public class App {
	
	
	public static void main(String[] args) {
		
		
		Controle c = new Controle();
		Menu menu = new Menu();
		int op = 7;
		
		do {
      	  	menu.ViewMenu();
			op = c.escolha();

            switch (op) {
            case 1:
            	c.cadastrarProfissional();
            	break;
            case 2:
            	c.cadastrarCliente();
            	break;
            case 3:
            	c.novoAtendimento();
          	    break;
            case 4:
            	do {
            		menu.MenuRelatorio();
            		op = c.escolha();
            		
            		switch(op) {
            		case 1:
            			c.relatorioRaca();
            			break;
            		case 2:
            			c.relatorioGenero();
            			break;
            		case 0:
            			op = -1;
            		}
            	}while(op != -1);
          	  	break;
            case 5:
            	c.historicoAtendimento();
          	  	break;
            case 0:
            	System.exit(0);
            default:
                menu.ViewMenu();
            }
        } while (op != -1);

	}

}
