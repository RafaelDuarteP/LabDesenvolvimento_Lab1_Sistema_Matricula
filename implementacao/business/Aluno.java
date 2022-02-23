package business;

import java.util.List;

public class Aluno extends Usuario{
    private int numeroDeMatricula;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, int id, String senha, int nMatricula) {
        super(nome, id, senha);
        this.numeroDeMatricula = nMatricula;
    }
}
