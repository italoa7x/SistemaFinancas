package control;

import dto.MoedaDTO;
import dto.ValorDTO;
import model.Valor;

public class ValorControl {
	private Valor valor;
	
	public ValorControl() {
		valor = new Valor();
	}
	
	public boolean salvar(ValorDTO obj) throws Exception {
		return valor.salvar(obj);
	}
	
	public ValorDTO listar() throws Exception {
		return valor.listar();
	}
	
	public ValorDTO listarValores(MoedaDTO moeda) throws Exception {
		return valor.listarValores(moeda);
	}
}
