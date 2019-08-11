package daoJPA;

import dto.MoedaDTO;

public interface ITmoeda {

	public boolean salvar(MoedaDTO obj) throws Exception;
	
	public MoedaDTO listar() throws Exception;
	
	public MoedaDTO atualizar(MoedaDTO novo) throws Exception;
	
	public boolean excluir(MoedaDTO obj) throws Exception;
}
