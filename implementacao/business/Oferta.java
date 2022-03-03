package business;

import java.util.List;

public class Oferta {

	private static final int MAX_ALUNOS;

	static {
		MAX_ALUNOS = 60;
	}

	private boolean ativa;
	private List<Aluno> alunos;
	private List<Professor> professores;
	private Disciplina disciplina;
	private String semestre;

	public Oferta(boolean ativa, Disciplina disciplina, String semestre) {
		this.ativa = ativa;
		this.disciplina = disciplina;
		this.semestre = semestre;
	}

	public String getSemestre() {
		return semestre;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public boolean validarAtivacao() {
		ativa = alunos.size() >= 3;
		return ativa;
	}

	public boolean podeMatricular() {
		return alunos.size() < MAX_ALUNOS;
	}

	public boolean matricular(Aluno a) {
		if (podeMatricular()) {
			alunos.add(a);
			return true;
		}

		return false;

	}

	public void cancelarMatricula(Aluno a) {
		alunos.remove(a);
	}
	
	public void addProfessor(Professor p) {
		professores.add(p);
	}

}
