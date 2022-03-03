package business;

import java.util.List;

public class Professor extends Usuario {
	private static final long serialVersionUID = 1L;

	public Professor(String nome, String senha) {
		super(nome, senha, TipoUsuario.PROFESSOR);
	}

	public List<Aluno> consultar(Disciplina dis, String semestre) {

		Oferta o = dis.procurarOferta(semestre);
		return o.getAlunos();

	}

}
