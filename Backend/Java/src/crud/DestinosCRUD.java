package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelos.Destinos;

public class DestinosCRUD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();
		
		int opcao = 0, id = 0;
		
		String cidade = "", estado = "";
		
		do {
			
			System.out.println("\n============================== DESTINOS ==============================\n");
			System.out.println("1-Criar  2-Consultar  3-Atualizar  4-Deletar  5-Consultar por ID  0-Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a cidade: ");
				cidade = sc.nextLine();
				System.out.println("Digite o estado: ");
				estado = sc.nextLine();				
				
				Destinos destinos1 = new Destinos(cidade, estado);
				
				destinoDAO.create(destinos1);
				break;
			case 2:
				
				for (Destinos u : destinoDAO.read()) {
					System.out.println(u.toString());
				}
				
				
				destinoDAO.read();
				break;
			case 3:
				System.out.println("Digite o id: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite a cidade: ");
				cidade = sc.nextLine();
				System.out.println("Digite o estado: ");
				estado = sc.nextLine();
				
				
				Destinos destinos2 = new Destinos(id, cidade, estado);
				
				
				destinoDAO.update(destinos2);
				break;
			case 4:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				destinoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				Destinos destinos3 = destinoDAO.readById(id);
				
				System.out.println(destinos3.toString());
				break;
			default:
				
				break;
			
			}
			
		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();
	}		

}


