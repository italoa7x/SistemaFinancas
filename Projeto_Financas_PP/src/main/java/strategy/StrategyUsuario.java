package strategy;

import dto.UsuarioDTO;

public interface StrategyUsuario {

public boolean salvar(UsuarioDTO dto) throws Exception ;

public UsuarioDTO excluir(UsuarioDTO dto) throws Exception;

public UsuarioDTO atualizar(UsuarioDTO dto) throws Exception ;

public UsuarioDTO listar() throws Exception ;

public UsuarioDTO buscar(UsuarioDTO dto) throws Exception ;

public UsuarioDTO logar(UsuarioDTO dto) throws Exception;
}
