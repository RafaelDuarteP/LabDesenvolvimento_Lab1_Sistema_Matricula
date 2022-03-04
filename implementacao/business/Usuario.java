package business;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private int id;
	private static int proximoId = 0;
	private String senha;
	@SuppressWarnings("unused")
	private List<Curso> cursos;
	private TipoUsuario nivelAcesso;
	
	public static void setUltId(int n) {
		Usuario.proximoId = n;
	}

	public Usuario(String nome, String senha, TipoUsuario nivelAcesso) {
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		this.id = ++Usuario.proximoId;
	}

	public boolean logar(String senha) {

		return this.senha.equals(senha);

	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public boolean setSenha(String senha) {
		if ((senha.length() < 6 || senha.length() > 32))
			return false;
		this.senha = senha;
		return true;
	}

	public int getId() {
		return this.id;
	}

	public int getContador() {
		return this.id;
	}

	public TipoUsuario getNivelAcesso() {
		return nivelAcesso;
	}

}
