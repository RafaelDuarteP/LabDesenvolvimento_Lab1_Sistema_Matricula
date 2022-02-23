package business;

import java.util.List;

public class Professor extends Usuario {
	public Professor(String nome, int id, String senha) {
		super(nome, id, senha);
	}

	private List<Disciplina> disciplinas;

	public void consultar(Disciplina dis) {

	}

}
