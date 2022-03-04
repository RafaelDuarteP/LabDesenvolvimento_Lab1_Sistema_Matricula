package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Aluno;
import business.Disciplina;
import business.Professor;
import business.Secretario;
import business.TipoUsuario;
import business.Usuario;
import dados.Arquivo;

public class Sistema {

	static List<Usuario> usuarios;
	static List<Disciplina> disciplinas;

	public static void main(String[] args) throws IOException {
		Arquivo<Usuario> arqUser;
		Arquivo<Disciplina> arqDisc;
		arqUser = new Arquivo<>("usuarios.dat");
		arqDisc = new Arquivo<>("disciplinas.dat");
//
//		 usuarios = new ArrayList<>();
//		 disciplinas = new ArrayList<>();

		usuarios = arqUser.recuperarDados();
		disciplinas = arqDisc.recuperarDados();
		
		Usuario.setUltId(usuarios.size());

//		usuarios.add(new Secretario("Rafael", "1234"));
//		usuarios.add(new Secretario("Ian", "1234"));
//		usuarios.add(new Secretario("Kleyann", "1234"));
//		arqDisc.salvar(disciplinas);
//		arqUser.salvar(usuarios);

		Scanner teclado = new Scanner(System.in);
		Usuario user = login(teclado);
		int op;

		// System.out.println(usuarios.size());
//		for (Usuario a : usuarios) {
//			System.out.println(a.getNome() + " " + a.getId());
//		}
		
		System.out.printf("\n\nSeja bem-vindo(a) %s %s\n\n", user.getNivelAcesso(), user.getNome());

		op = menu(teclado, user);
		while (op != 0) {

			switch (op) {
			case 1:
				matricular(teclado, user);
				break;
			case 2:
				cancelarMatricula(teclado, user);
				break;
			case 3:
				consultarDisciplinas(teclado, user);
				break;
			case 4:
				cadastrarUsuario(teclado);
				break;
			case 5:
				cadastrarDisciplina(teclado);
				break;
			case 6:
				cadastrarOferta(teclado);
				break;
			default:
				break;
			}
			op = menu(teclado, user);
		}

		arqDisc.salvar(disciplinas);
		arqUser.salvar(usuarios);

	}

	public static Usuario login(Scanner teclado) {
		int id;
		Usuario user = null;
		String senha;

		while (user == null) {
			senha = null;
			System.out.println("Digite o id:");
			id = Integer.parseInt(teclado.nextLine());

			for (Usuario u : usuarios) {
				if (u.getId() == id) {
					System.out.println("Digite a senha:");
					senha = teclado.nextLine();
					if (u.logar(senha)) {
						user = u;
						break;
					} else {
						System.out.println("Senha incorreta");
					}
				}
			}
			if (senha == null) {
				System.out.println("Usuario não encontrado");
			}
		}

		return user;
	}

	public static int menu(Scanner teclado, Usuario user) {
		System.out.println("Escolha uma opção:");
		if (user.getNivelAcesso().equals(TipoUsuario.ALUNO)) {
			System.out.println("1 - Matricular");
			System.out.println("2 - Cancelar Matricula");
		} else if (user.getNivelAcesso().equals(TipoUsuario.PROFESSOR)) {
			System.out.println("3 - Consultar Disciplina");
		} else if (user.getNivelAcesso().equals(TipoUsuario.SECRETARIO)) {

			System.out.println("4 - Cadastrar novo usuário");
			System.out.println("5 - Cadastrar nova Disciplina");
			System.out.println("6 - Cadastrar nova oferta");
		}
		System.out.println("0 - sair");

		return Integer.parseInt(teclado.nextLine());
	}

	public static void matricular(Scanner teclado, Usuario user) {
		int op;
		System.out.println("Escolha a disciplina:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.printf("%d - %s \n", i, disciplinas.get(i).getNome());
		}

		op = Integer.parseInt(teclado.nextLine());

		disciplinas.get(op).getUltimaOferta().matricular((Aluno) user);

	}

	public static void cancelarMatricula(Scanner teclado, Usuario user) {
		int op;
		System.out.println("Escolha a disciplina:");
		List<Disciplina> d = ((Aluno) user).getDisciplinas();
		for (int i = 0; i < d.size(); i++) {
			System.out.printf("%d - %s \n", i, d.get(i).getNome());
		}

		op = Integer.parseInt(teclado.nextLine());

		d.get(op).getUltimaOferta().cancelarMatricula((Aluno) user);

	}

	public static void consultarDisciplinas(Scanner teclado, Usuario user) {
		int op;
		String semestre;
		System.out.println("Escolha a disciplina:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.printf("%d - %s \n", i, disciplinas.get(i).getNome());
		}

		op = Integer.parseInt(teclado.nextLine());

		System.out.println("Digite o semestre");
		semestre = teclado.nextLine();

		List<Aluno> alunos = ((Professor) user).consultar(disciplinas.get(op), semestre);

		for (Aluno a : alunos) {
			System.out.println(a.getNome());
		}
	}

	public static void cadastrarUsuario(Scanner teclado) {
		Usuario u;
		int op, mat;
		String nome, senha;

		System.out.println("Digite o tipo de usuario:");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		System.out.println("3 - Secretaria");

		op = Integer.parseInt(teclado.nextLine());

		System.out.println("Digite o nome:");
		nome = teclado.nextLine();
		System.out.println("Digite a senha:");
		senha = teclado.nextLine();

		switch (op) {
		case 1:
			u = new Aluno(nome, senha);
			break;
		case 2:
			u = new Professor(nome, senha);
			break;
		case 3:
			u = new Secretario(nome, senha);
			break;
		default:
			u = null;
			break;
		}

		usuarios.add(u);
		System.out.println("Dados do novo usuario:");
		System.out.printf("\t id: %d, nome: %s, senha: %s\n\n", u.getId(), u.getNome(), u.getSenha());

	}

	public static void cadastrarDisciplina(Scanner teclado) {
		String nome;
		int obrigatoria;
		System.out.println("Digite o nome:");
		nome = teclado.nextLine();
		System.out.println("Será obrigatória? \n1 - Sim \n2 - Não");
		obrigatoria = Integer.parseInt(teclado.nextLine());

		disciplinas.add(new Disciplina(obrigatoria == 1, nome));
	}
	
	public static void cadastrarOferta(Scanner teclado) {
		int op;
		String semestre;
		System.out.println("Escolha a disciplina:");
		for (int i = 0; i < disciplinas.size(); i++) {
			System.out.printf("%d - %s \n", i, disciplinas.get(i).getNome());
		}

		op = Integer.parseInt(teclado.nextLine());

		System.out.println("Digite o semestre:");
		semestre = teclado.nextLine();
		
		disciplinas.get(op).novaOferta(semestre);
	}

}
