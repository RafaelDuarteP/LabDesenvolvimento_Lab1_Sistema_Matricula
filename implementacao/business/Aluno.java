package business;

import java.util.ArrayList;
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
		disciplinas = new ArrayList<>();
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void addDisciplina(Disciplina d) {
		disciplinas.add(d);
		
	}
}
