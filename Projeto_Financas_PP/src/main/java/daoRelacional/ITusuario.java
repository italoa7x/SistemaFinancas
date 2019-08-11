package daoRelacional;

import dto.UsuarioDTO;

public interface ITusuario {

	public boolean salvar(UsuarioDTO obj) throws Exception;

	public boolean excluir(int id) throws Exception;

	public boolean atualizar(UsuarioDTO obj) throws Exception;

	public UsuarioDTO listar() throws Exception;
	
	public UsuarioDTO logar(UsuarioDTO obj) throws Exception;

}
