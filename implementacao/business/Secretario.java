package business;

public class Secretario extends Usuario{
    public Secretario(String nome, String senha) {
        super(nome, senha, TipoUsuario.SECRETARIO);
    }
}
