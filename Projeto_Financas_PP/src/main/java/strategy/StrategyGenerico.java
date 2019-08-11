package strategy;

import dto.UsuarioDTO;

public interface StrategyGenerico {

	public boolean salvar(UsuarioDTO obj)throws Exception;
	
	public Object excluir(UsuarioDTO obj) throws Exception;
	
	public Object atualizar(UsuarioDTO novo) throws Exception;
	
	public Object listar() throws Exception;
	
	public Object buscar(UsuarioDTO obj) throws Exception;
	
	public Object logar(UsuarioDTO obj) throws Exception;
}

