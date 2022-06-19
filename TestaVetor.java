
import java.util.Scanner;

public class TestaVetor {

	public static void main(String[] args) {
		int opcao = 0;
        int qnt, valor, deposito;
		
		Scanner sc = new Scanner(System.in);
		
		Vetor lista = new Vetor();

		do {
			System.out.println("\n\n                        ### Exchange do Otavio ###");
			System.out.println("\n                  =========================================");
			System.out.println("              	  |                                         |");
			System.out.println("              	  |                            "+"Saldo: " + lista.valornaconta() +  "  |");
			System.out.println("              	  |     1 - Comprar                         |");
			System.out.println("                  |     2 - Vender                          |");
			System.out.println("                  |     3 - Depositar saldo na carteira     |");
			System.out.println("                  |     4 - Mostrar Carteira		    |");
			System.out.println("                  |     0 - Sair                            |");
			System.out.println("                  ==========================================\n");
			
			opcao = sc.nextInt();
			System.out.print("\n");
			switch (opcao) {
		case 1: 
			System.out.println("\nOpcao escolhida :"+opcao);
			
			System.out.println("\nQuantidade de ações que deseja comprar:");
            qnt = sc.nextInt();
			System.out.println("\nQual o valor de cada ação:");
			valor = sc.nextInt();	
			if(lista.valornaconta() < qnt*valor){
				System.out.println("\nVocê não possui saldo sulficiente para comprar esse valor em ações!");
			}
			else {
				LinkedList comprarAcao = new LinkedList(qnt, valor);
				lista.comprar(comprarAcao);
				
				System.out.println("\nAções Compradas!");
			}
			
			break;
        case 2: 
			System.out.println("\nOpcao escolhida :"+opcao);
			System.out.println("\nVocê possui " + lista.totaldeAcoes() + " ações para vender.");
            System.out.println("\nDeseja vender quantas ações ?");
            qnt = sc.nextInt();
			System.out.println("\nQual o valor unitário de venda ?");
			valor = sc.nextInt();
			
			lista.vender(qnt, valor);
			break;
		case 3: 
			System.out.println("\nOpcao escolhida :"+opcao);
            System.out.println("\nQual o valor que depositar ?");
            deposito = sc.nextInt();	
			lista.deposito(deposito);	
		case 4:
			//JOptionPane.showMessageDialog(null, lista);
			lista.MostrarCarteira();	
			break;
		case 0:
			break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    } while (opcao != 0);
		sc.close();
	}
}
