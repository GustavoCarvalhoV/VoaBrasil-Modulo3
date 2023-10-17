package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import dao.PassagemDAO;
import dao.UsuarioDAO;
import modelos.Destinos;
import modelos.Passagens;
import modelos.Usuarios;

public class PassagensCRUD {

	public static void main(String[] args) {		

		Scanner sc = new Scanner(System.in);
		PassagemDAO passagemDAO = new PassagemDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		
		int opcao = 0, id = 0, id_destino = 0, id_usuario = 0;
		
		String horario = "", dataIda = "", dataVolta = "";
		float preco = 0;
		
		do {
			
			System.out.println("\n============================== PASSAGENS ==============================\n");
			System.out.println("1-Criar  2-Consultar  3-Atualizar  4-Deletar  5-Consultar por ID  0-Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o preco: ");
				preco = sc.nextFloat();
				sc.nextLine();
				System.out.println("Digite o horario: ");
				horario = sc.nextLine();
				System.out.println("Digite a data de ida: ");
				dataIda = sc.nextLine();
				System.out.println("Digite a data de volta: ");
				dataVolta = sc.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o id do usuario: ");
				id_usuario = sc.nextInt();
				sc.nextLine();
				
				Usuarios usuario1 = usuarioDAO.readById(id_usuario);
				Destinos destino1 = destinoDAO.readById(id_destino);
				
				
				Passagens passagens1 = new Passagens(preco, horario, dataIda, dataVolta, usuario1, destino1);
				
				passagemDAO.create(passagens1);
				break;
			case 2:
				
				for (Passagens u : passagemDAO.read()) {
					System.out.println(u.toString());									
				}								
				break;
			case 3:
				System.out.println("Digite o id da passagem: ");
				id = sc.nextInt(); 
				sc.nextLine();
				System.out.println("Digite o preco: ");
				preco = sc.nextFloat();
				sc.nextLine();
				System.out.println("Digite o horario: ");
				horario = sc.nextLine();
				System.out.println("Digite a data de ida: ");
				dataIda = sc.nextLine();
				System.out.println("Digite a data de volta: ");
				dataVolta = sc.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o id do usuario: ");
				id_usuario = sc.nextInt();
				sc.nextLine();
				
				Usuarios usuario2 = usuarioDAO.readById(id_usuario);
				Destinos destino2 = destinoDAO.readById(id_destino);
				
				
				Passagens passagens2 = new Passagens(id, preco, horario, dataIda, dataVolta, usuario2, destino2);
				
				passagemDAO.update(passagens2);
				break;
			case 4:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				passagemDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				Passagens passagens3 = passagemDAO.readById(id);
				
				System.out.println(passagens3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");			
				break;
			
			}
			
		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();
	}
	
}
