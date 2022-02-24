package business;

import java.util.List;

public class Curso {

	private String nome;
	private int creditos;
	private List<Disciplina> disciplinas;

	public Curso(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
	}

}
