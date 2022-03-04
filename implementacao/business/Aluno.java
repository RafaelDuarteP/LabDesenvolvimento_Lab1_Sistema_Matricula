package business;

import java.util.List;

public class Aluno extends Usuario {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private int numeroDeMatricula;
	private static int proxMatricula = 0;
	private List<Disciplina> disciplinas;

	public Aluno(String nome, String senha) {
		super(nome, senha, TipoUsuario.ALUNO);
		this.numeroDeMatricula = proxMatricula;
		proxMatricula++;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
