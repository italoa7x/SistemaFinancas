package model;

import java.util.ArrayList;

import daoJPA.ITmoeda;
import daoJPA.ITusuario;
import daoJPA.MoedaDaoJPA;
import daoJPA.UsuarioDaoJPA;
import dto.MoedaDTO;

public class Moeda  {
	private String nome;
	private String tipo;
	private ArrayList<Valor> historico = new ArrayList<Valor>();
	
	private ITmoeda moedaDAO;
	
	public Moeda() {
		moedaDAO = new MoedaDaoJPA();
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Valor> getHistorico() {
		return historico;
	}
	public void setHistorico(ArrayList<Valor> historico) {
		this.historico = historico;
	}
	
	
	public boolean salvar(MoedaDTO dto) throws Exception {
			return moedaDAO.salvar(dto);
	}

	public boolean excluir(MoedaDTO dto) throws Exception {
			return moedaDAO.excluir(dto);
	}

	public MoedaDTO atualizar(MoedaDTO dto) throws Exception {
			return moedaDAO.atualizar(dto);
	}

	public MoedaDTO listar() throws Exception {
			return moedaDAO.listar();
	}

//	public Object buscar(MetaDTO dto) throws Exception {
//			return metaDAO.buscar(dto);
//	}

//	public Object logar(MetaDTO dto) throws Exception {
//			return metaDAO.logar(dto);
//	}
	
	
	
	
	
}
