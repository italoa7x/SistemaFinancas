package control;

import dto.UsuarioDTO;
import model.RecuperarEmail;
import model.Usuario;



public class ControlerUsuario{

	

	private Usuario usuario;
	private RecuperarEmail recuperador;

	public ControlerUsuario() {
		usuario = new Usuario();
		recuperador = new RecuperarEmail();
	}

	public boolean salvar(UsuarioDTO dto) throws Exception {
		return usuario.salvar(dto);
	}

	public UsuarioDTO excluir(UsuarioDTO dto) throws Exception {
		return usuario.excluir(dto);
	}

	public UsuarioDTO atualizar(UsuarioDTO dto) throws Exception {
		return usuario.atualizar(dto);
	}

	public UsuarioDTO listar() throws Exception {
		return usuario.listar();
	}

	public UsuarioDTO buscar(UsuarioDTO dto) throws Exception {
		return usuario.buscar(dto);
	}

	public UsuarioDTO logar(UsuarioDTO dto) throws Exception {
		return usuario.logar(dto);
	}
	
	public void recuperarSenha(UsuarioDTO dto) throws Exception {
		recuperador.enviarEmail(dto);
	}
	

}
