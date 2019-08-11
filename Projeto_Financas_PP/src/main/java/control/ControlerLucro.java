package control;

import dto.LucroDTO;
import model.Lucro;

public class ControlerLucro {
	private Lucro lucro;
	
	public ControlerLucro() {
		lucro = new Lucro();
	}
	
	public boolean salvar(LucroDTO obj) throws Exception {
		return lucro.salvar(obj);
	}
	
	public LucroDTO listar() throws Exception {
		return lucro.listar();
	}
}
