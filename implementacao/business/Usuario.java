package business;

import java.util.List;

public class Usuario {
	private String nome;
	private int id;
	public static int proximoId=0;
	private String senha;
	private List<Curso> cursos;
	private TipoUsuario nivelAcesso;

	public Usuario(String nome, String senha, TipoUsuario nivelAcesso) {
		this.nome = nome;
		this.senha = senha;
		this.id=Usuario.proximoId++;
	}



	public boolean logar(String senha) {

		return this.senha.equals(senha);

	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public boolean setSenha(String senha){
		if((senha.length() < 6 || senha.length() > 32)) return false;
		this.senha = senha;
	}

	public int getId() {
		return this.id;
	}

	public int getContador() {
		return this.id;
	}

	

}
