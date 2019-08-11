package model;

import java.awt.Image;
import java.util.ArrayList;

import daoJPA.ITusuario;
import daoJPA.UsuarioDaoJPA;

import dto.UsuarioDTO;

public class Usuario {
	private String nome, cpf, telefone, email;
	private Image foto;
	
	private ITusuario usuarioDAO;
	
	public Usuario() {
		usuarioDAO = new UsuarioDaoJPA();
	}
	

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 //////////////////////////////////////////////////////////////////////////////////////////////

	public boolean salvar(UsuarioDTO obj) throws Exception{
		return usuarioDAO.salvar(obj);
	}
	
	public UsuarioDTO atualizar(UsuarioDTO novo) throws Exception{
		return usuarioDAO.atualizar(novo);
	}
	
	
	public UsuarioDTO logar(UsuarioDTO obj) throws Exception{
		return usuarioDAO.logar(obj);
	}
	
	public UsuarioDTO listar() throws Exception{
		return usuarioDAO.listar();
	}
	
	public UsuarioDTO excluir(UsuarioDTO dto) throws Exception {
		return usuarioDAO.excluir(dto);
	}
	
	public UsuarioDTO buscar(UsuarioDTO dto) throws Exception {
		return usuarioDAO.buscar(dto);
	}
	
	public UsuarioDTO buscarPorEmail(UsuarioDTO dto) throws Exception {
		return usuarioDAO.buscarPorEmail(dto);
	}
}

