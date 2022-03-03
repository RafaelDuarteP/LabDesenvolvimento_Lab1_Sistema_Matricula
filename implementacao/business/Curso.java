package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private int creditos;
	private List<Disciplina> disciplinas;
	private List<Usuario> usuarios;

	public Curso(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
		this.disciplinas = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	public void addDisciplina(Disciplina d) {
		disciplinas.add(d);
	}

	public void addUsuario(Usuario e) {
		usuarios.add(e);
	}

	public String getNome() {
		return this.nome;
	}

	public int getCreditos() {
		return this.creditos;
	}

}
