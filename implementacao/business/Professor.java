package business;

import java.util.List;

public class Professor extends Usuario {
	public Professor(String nome, String senha) {
		super(nome, senha);
	}

	public List<Aluno> consultar(Disciplina dis, String semestre) {

		Oferta o = dis.procurarOferta(semestre);
		return o.getAlunos();

	}

}
