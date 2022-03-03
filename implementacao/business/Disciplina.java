package business;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	
	private String nome;
	private boolean obtigatoria;
	private List<Oferta> ofertas;

	public Disciplina(boolean obtigatoria, String nome) {
		this.obtigatoria = obtigatoria;
		this.nome = nome;
		this.ofertas = new ArrayList<>();
	}

	public Oferta procurarOferta(String semestre) {
		for (Oferta o : ofertas) {
			if (o.getSemestre().equalsIgnoreCase(semestre))
				return o;
		}
		return null;
	}
	
	public void novaOferta(String semestre) {
		Oferta o = new Oferta(true, this, semestre);
		ofertas.add(o);
	}
	
	public boolean isObrigatoria() {
		return this.obtigatoria;
	}

	public String getNome() {
		return this.nome;
	}
	
	public Oferta getUltimaOferta(){
		return ofertas.get(ofertas.size()-1);
	}


}
