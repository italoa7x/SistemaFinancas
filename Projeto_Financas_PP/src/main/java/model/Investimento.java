package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daoJPA.ITinvestimento;

import daoJPA.InvestimentoDaoJPA;

import dto.InvestimentoDTO;
import dto.LucroDTO;
import dto.ValorAtualDTO;
import model.requisicoes.FachadaRequisicoes;



public class Investimento {
	private String nome;
	private Status status;
	private ArrayList <Lucro> lucro;
	private double margemLucro;
	private double valorInvestido;
	private double valorInvestimento;
	private Usuario usuario;
	private Date data_inicio, data_fim;
	
	private ITinvestimento investimentoDAO;
	
	public Investimento() {
		investimentoDAO = new InvestimentoDaoJPA();
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Lucro> getLucro() {
		return lucro;
	}

	public void setLucro(ArrayList<Lucro> lucro) {
		this.lucro = lucro;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getValorInvestido() {
		return valorInvestido;
	}
	
	public double getValorInvestimento() {
		return valorInvestimento;
	}
	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}
	public void setValorInvestido(double valor) {
		this.valorInvestido = valor;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public boolean salvar(InvestimentoDTO dto) throws Exception {
		
			return investimentoDAO.salvar(dto);
		
		
	}
	
	public boolean excluir(InvestimentoDTO dto) throws Exception {
		
			return investimentoDAO.excluir(dto);
	
		
	}
	
	public InvestimentoDTO atualizar(InvestimentoDTO dto) throws Exception {
		
			return investimentoDAO.atualizar(dto);
	
	}
	
	public InvestimentoDTO listar() throws Exception {
		
			return investimentoDAO.listar();
	
	}

	public InvestimentoDTO buscar(InvestimentoDTO dto) throws Exception {
	
			return investimentoDAO.buscar(dto);
	
	}
	
//	public InvestimentoDTO logar(InvestimentoDTO dto) throws Exception {
//
//			return investimentoDAO.logar(dto);
//	
//	}
	
	public InvestimentoDTO calcularMargemDeLucro(InvestimentoDTO dto) {
		InvestimentoDTO investimento = null;
        try {
           investimento = investimentoDAO.buscar(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        double valorFinal = 0;
        for( LucroDTO lucros : investimento.getLucro()) {
            valorFinal = lucros.getValor();
        }
        valorFinal = valorFinal + investimento.getValor();
        double valorInicial =  investimento.getValor();

        investimento.setMargem(((valorFinal - valorInicial)/valorInicial)*100);

        return investimento;

    }
	
	public void atualizarInvestimentos() {
		InvestimentoDaoJPA invDao = new InvestimentoDaoJPA();
		InvestimentoDTO investimento = null;
		try{
			investimento = invDao.listar();
		}catch(Exception e) {
			
		}
		if(!investimento.getTodosInvetismento().isEmpty()) {
		FachadaRequisicoes fachada = new FachadaRequisicoes();
		ValorAtualDTO valor = fachada.recuperarRequisicoes();
		Date data = new Date();
		
		for(InvestimentoDTO inv:investimento.getTodosInvetismento()) {
			switch (inv.getMoeda().getNome()) {
				case "BCash":
					double valorlucro = inv.getValor() * Double.parseDouble(valor.getBCash()) - inv.getValor(); 
					List<LucroDTO> lucro = inv.getLucro();
					LucroDTO lucrodto = null;
					for(LucroDTO l : lucro) {
						lucrodto = l;
					}
					lucrodto.setData(data);
					lucrodto.setValor(valorlucro);
					lucro.add(lucrodto);
					inv.setLucro(lucro);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "BitCoin":
					double valorlucro2 = inv.getValor() * Double.parseDouble(valor.getBitCoin()) - inv.getValor(); 
					List<LucroDTO> lucro2= inv.getLucro();
					LucroDTO lucrodto2 = null;
					for(LucroDTO l : lucro2) {
						lucrodto2 = l;
					}
					lucrodto2.setData(data);
					lucrodto2.setValor(valorlucro2);
					lucro2.add(lucrodto2);
					inv.setLucro(lucro2);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "Dolar":
					double valorlucro3 = inv.getValor() * Double.parseDouble(valor.getDolar()) - inv.getValor(); 
					List<LucroDTO> lucro3= inv.getLucro();
					LucroDTO lucrodto3 = null;
					for(LucroDTO l : lucro3) {
						lucrodto3 = l;
					}
					lucrodto3.setData(data);
					lucrodto3.setValor(valorlucro3);
					lucro3.add(lucrodto3);
					inv.setLucro(lucro3);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "DolarCan":
					double valorlucro4 = inv.getValor() * Double.parseDouble(valor.getDolarCan()) - inv.getValor(); 
					List<LucroDTO> lucro4= inv.getLucro();
					LucroDTO lucrodto4 = null;
					for(LucroDTO l : lucro4) {
						lucrodto4 = l;
					}
					lucrodto4.setData(data);
					lucrodto4.setValor(valorlucro4);
					lucro4.add(lucrodto4);
					inv.setLucro(lucro4);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "Ethereum":
					double valorlucro6 = inv.getValor() * Double.parseDouble(valor.getEthereum()) - inv.getValor(); 
					List<LucroDTO> lucro6= inv.getLucro();
					LucroDTO lucrodto6 = null;
					for(LucroDTO l : lucro6) {
						lucrodto6 = l;
					}
					lucrodto6.setData(data);
					lucrodto6.setValor(valorlucro6);
					lucro6.add(lucrodto6);
					inv.setLucro(lucro6);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "Euro":
					double valorlucro7 = inv.getValor() * Double.parseDouble(valor.getEuro()) - inv.getValor(); 
					List<LucroDTO> lucro7= inv.getLucro();
					LucroDTO lucrodto7 = null;
					for(LucroDTO l : lucro7) {
						lucrodto7 = l;
					}
					lucrodto7.setData(data);
					lucrodto7.setValor(valorlucro7);
					lucro7.add(lucrodto7);
					inv.setLucro(lucro7);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "Libra":
					double valorlucro8 = inv.getValor() * Double.parseDouble(valor.getLibra()) - inv.getValor(); 
					List<LucroDTO> lucro8= inv.getLucro();
					LucroDTO lucrodto8 = null;
					for(LucroDTO l : lucro8) {
						lucrodto8 = l;
					}
					lucrodto8.setData(data);
					lucrodto8.setValor(valorlucro8);
					lucro8.add(lucrodto8);
					inv.setLucro(lucro8);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "LiteCoin":
					double valorlucro9 = inv.getValor() * Double.parseDouble(valor.getLiteCoin()) - inv.getValor(); 
					List<LucroDTO> lucro9= inv.getLucro();
					LucroDTO lucrodto9 = null;
					for(LucroDTO l : lucro9) {
						lucrodto9 = l;
					}
					lucrodto9.setData(data);
					lucrodto9.setValor(valorlucro9);
					lucro9.add(lucrodto9);
					inv.setLucro(lucro9);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
				case "XRP":
					double valorlucro0 = inv.getValor() * Double.parseDouble(valor.getXRP()) - inv.getValor(); 
					List<LucroDTO> lucro0= inv.getLucro();
					LucroDTO lucrodto0 = null;
					for(LucroDTO l : lucro0) {
						lucrodto0 = l;
					}
					lucrodto0.setData(data);
					lucrodto0.setValor(valorlucro0);
					lucro0.add(lucrodto0);
					inv.setLucro(lucro0);
					try{
						invDao.atualizar(inv);
					}catch(Exception e){
						
					}
				break;
			}
			
			
		}
		
	}
	}
}
