package daoRelacional;

import dto.MoedaDTO;

public interface ITmoeda {

	public boolean salvar(MoedaDTO obj) throws Exception;
	
	public MoedaDTO listar() throws Exception;
	
	public boolean atualizar(MoedaDTO novo) throws Exception;
	
	public boolean excluir(int id) throws Exception;
}
