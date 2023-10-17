package crud;

import java.util.Scanner;

import dao.UsuarioDAO;
import modelos.Usuarios;

public class UsuariosCRUD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		int opcao = 0, id = 0;
		
		String nome = "", sobrenome = "", rg = "", cpf = "", contato = "", email = "", senha = "";
		
		do {
			
			System.out.println("\n============================== USUARIOS ==============================\n");
			System.out.println("1-Criar  2-Consultar  3-Atualizar  4-Deletar  5-Consultar por ID  0-Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				nome = sc.nextLine();
				System.out.println("Digite o sobrenome: ");
				sobrenome = sc.nextLine();
				System.out.println("Digite o rg: ");
				rg = sc.nextLine();
				System.out.println("Digite o cpf: ");
				cpf = sc.nextLine();
				System.out.println("Digite o contato: ");
				contato = sc.nextLine();
				System.out.println("Digite o email: ");
				email = sc.nextLine();
				System.out.println("Digite a senha: ");
				senha = sc.nextLine();
				
				Usuarios usuario1 = new Usuarios(nome, sobrenome, rg, cpf, contato, email, senha);
				
				usuarioDAO.create(usuario1);
				break;
			case 2:
				
				for (Usuarios u : usuarioDAO.read()) {
					System.out.println(u.toString());
				}
				
				
				usuarioDAO.read();
				break;
			case 3:
				System.out.println("Digite o id: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o nome: ");
				nome = sc.nextLine();
				System.out.println("Digite o sobrenome: ");
				sobrenome = sc.nextLine();
				System.out.println("Digite o rg: ");
				rg = sc.nextLine();
				System.out.println("Digite o cpf: ");
				cpf = sc.nextLine();
				System.out.println("Digite o contato: ");
				contato = sc.nextLine();
				System.out.println("Digite o email: ");
				email = sc.nextLine();
				System.out.println("Digite a senha: ");
				senha = sc.nextLine();
				
				
				Usuarios usuario2 = new Usuarios(id, nome, sobrenome, rg, cpf, contato, email, senha);
				
				
				usuarioDAO.update(usuario2);
				break;
			case 4:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				usuarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id: ");
				id = sc.nextInt();
				sc.nextLine();
				
				Usuarios usuario3 = usuarioDAO.readById(id);
				
				System.out.println(usuario3.toString());
				break;
			default:
				
				break;
			
			}
			
		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();
	}
}
