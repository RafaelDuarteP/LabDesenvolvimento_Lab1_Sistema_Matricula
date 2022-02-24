package business;

import java.util.List;

public class Disciplina {

	private static final int MAX_ALUNOS;

	static {
		MAX_ALUNOS = 60;
	}

	private boolean obtigatoria;
	private boolean ativa;
	private List<Aluno> matriculadosAlunos;
	private List<Professor> professores;

	public Disciplina(boolean obtigatoria, boolean ativa) {
		this.obtigatoria = obtigatoria;
		this.ativa = ativa;
	}

	public boolean validarAtivacao() {
		return true;
	}

	public boolean podeMatricular() {
		return true;
	}

	public boolean matricular() {
		return true;
	}

	public void cancelar() {

	}

}
