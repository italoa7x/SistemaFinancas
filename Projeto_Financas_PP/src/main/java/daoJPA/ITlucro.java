package daoJPA;

import dto.LucroDTO;

public interface ITlucro {
	
	public boolean salvar(LucroDTO obj) throws Exception;
	
	public LucroDTO listar() throws Exception;
}
