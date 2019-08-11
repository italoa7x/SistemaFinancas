package model;

import java.util.Date;

import daoJPA.ITvalor;
import daoJPA.MoedaDaoJPA;
import daoJPA.ValorDaoJPA;
import dto.MoedaDTO;
import dto.ValorAtualDTO;
import dto.ValorDTO;
import model.requisicoes.FachadaRequisicoes;

public class Valor {
	private ITvalor valordao;
	private double valor;
	private Date data;

	public Valor() {
		valordao = new ValorDaoJPA();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean salvar(ValorDTO obj) throws Exception {
		return valordao.salvar(obj);
	}

	public ValorDTO listar() throws Exception {
		return valordao.listar();
	}

	public void atualizarValores() throws Exception {
		Date data = new Date();
		ValorDTO dto = new ValorDTO();
		ValorDaoJPA vdao = new ValorDaoJPA();
		MoedaDaoJPA mdao = new MoedaDaoJPA();
		MoedaDTO moeda = null;
		try {
			dto = valordao.listar();
		} catch (Exception e) {
			throw new Exception("Erro o buscar moedas. " + e.getMessage());
		}
		if (!dto.getValoresCadastrados().isEmpty()) {
			for (ValorDTO valor : dto.getValoresCadastrados()) {
				this.data = valor.getData();
			}

			if (this.data != data) {
				FachadaRequisicoes fachada = new FachadaRequisicoes();
				ValorAtualDTO valor = fachada.recuperarRequisicoes();

				moeda = mdao.listar();
				
				for (MoedaDTO m : moeda.getTodasMoedas()) {
					ValorDTO valorEscolhido;
					
					if (m.getNome().equalsIgnoreCase("bitcoin")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getBitCoin()));
						vdao.salvar(valorEscolhido);
						
					} else if (m.getNome().equalsIgnoreCase("bcash")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getBCash()));
						vdao.salvar(valorEscolhido);
						
					} else if (m.getNome().equalsIgnoreCase("dolar")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getDolar()));
						vdao.salvar(valorEscolhido);
						
					} else if (m.getNome().equalsIgnoreCase("dolarcan")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getDolarCan()));
						vdao.salvar(valorEscolhido);
						
					} else if(m.getNome().equalsIgnoreCase("ethereum")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getEthereum()));
						vdao.salvar(valorEscolhido);
						
					} else if(m.getNome().equalsIgnoreCase("euro")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getEuro()));
						vdao.salvar(valorEscolhido);
						
					} else if(m.getNome().equalsIgnoreCase("libra")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getLibra()));
						vdao.salvar(valorEscolhido);
					} else if(m.getNome().equalsIgnoreCase("litecoint")) {
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getLiteCoin()));
						vdao.salvar(valorEscolhido);
						
					} else if(m.getNome().equalsIgnoreCase("xrp")){
						valorEscolhido = new ValorDTO();
						valorEscolhido.setData(data);
						valorEscolhido.setMoeda(m);
						valorEscolhido.setValor(Double.parseDouble(valor.getXRP()));
						vdao.salvar(valorEscolhido);
					}
				}

			}
		}
	}
	
	public ValorDTO listarValores(MoedaDTO moeda) throws Exception {
		return valordao.listarValores(moeda);
	}
}
