package business;

import java.util.List;

public class Usuario {
	private String nome;
	private int id;
	public static int proximoId=0;
	private String senha;
	private List<Curso> cursos;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.id=Usuario.proximoId++;
	}

	public String getNome() {
		return this.nome;
	}

	public int getId() {
		return this.id;
	}
	

	public String getSenha() {
		return this.senha;
	}
	public int getContador() {
		return this.id;
	}

	public boolean logar(String senha) {

		return this.senha.equals(senha);

	}

	

}
