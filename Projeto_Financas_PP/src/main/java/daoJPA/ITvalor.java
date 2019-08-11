package daoJPA;

import dto.MoedaDTO;
import dto.ValorDTO;

public interface ITvalor {

	public boolean salvar(ValorDTO obj) throws Exception;
	
	public ValorDTO listar() throws Exception;
	
	public ValorDTO listarValores(MoedaDTO moeda) throws Exception;
	
}
