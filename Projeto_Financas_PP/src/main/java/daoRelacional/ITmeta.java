package daoRelacional;

import dto.MetaDTO;

public interface ITmeta {

	public int salvar(MetaDTO obj) throws Exception;
	
	public MetaDTO listar() throws Exception;
	
	public boolean excluir(int id) throws Exception;
	
	public boolean atualizar(MetaDTO novo) throws Exception;
	
}
