package daoJPA;

import java.util.ArrayList;

import dto.UsuarioDTO;

public interface ITusuario {

	public boolean salvar(UsuarioDTO obj) throws Exception;

	public UsuarioDTO excluir(UsuarioDTO obj) throws Exception;

	public UsuarioDTO atualizar(UsuarioDTO obj) throws Exception;

	public UsuarioDTO listar() throws Exception;

	public UsuarioDTO buscar(UsuarioDTO obj) throws Exception;
	
	public UsuarioDTO logar(UsuarioDTO usuario) throws Exception;
	
	public UsuarioDTO buscarPorEmail(UsuarioDTO dto) throws Exception;
	
}
