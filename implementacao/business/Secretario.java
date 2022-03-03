package business;

public class Secretario extends Usuario {
	private static final long serialVersionUID = 1L;

	public Secretario(String nome, String senha) {
		super(nome, senha, TipoUsuario.SECRETARIO);
	}
}
