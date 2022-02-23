package business;

import java.util.List;

public class Usuario {
	private String nome;
	private int id;
	private String senha;
	private List<Curso> cursos;

	public Usuario(String nome, int id, String senha) {
		this.nome = nome;
		this.id = id;
		this.senha = senha;
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

	public boolean logar() {
		return true;

	}

	public void sair() {

	}

}
