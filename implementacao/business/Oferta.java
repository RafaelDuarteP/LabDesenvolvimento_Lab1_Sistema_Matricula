package business;

import java.util.List;

public class Oferta {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private Disciplina disciplina;
	private String semestre;
	
	public String getSemestre() {
		return semestre;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
