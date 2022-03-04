package business;

import java.io.Serializable;

public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private int id;
	@SuppressWarnings("unused")
	private Aluno aluno;

	public Matricula(int id, Aluno aluno) {
		this.id = id;
		this.aluno = aluno;
	}
}
