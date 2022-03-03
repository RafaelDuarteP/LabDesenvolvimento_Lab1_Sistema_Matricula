package business;

import java.util.List;

public class Aluno extends Usuario{
    private int numeroDeMatricula;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, String senha, int nMatricula) {
        super(nome, senha);
        this.numeroDeMatricula = nMatricula;
    }
}
