package model.requisicoes;

import java.text.Format;

import dto.MoedaDTO;
import dto.ValorAtualDTO;
import model.requisicoes.ITrequeste;
import model.requisicoes.RequisicaoBCash;
import model.requisicoes.RequisicaoBitCoin;
import model.requisicoes.RequisicaoDolar;
import model.requisicoes.RequisicaoDolarCan;
import model.requisicoes.RequisicaoEthereum;
import model.requisicoes.RequisicaoEuro;
import model.requisicoes.RequisicaoLibra;
import model.requisicoes.RequisicaoLiteCoin;
import model.requisicoes.RequisicaoXRP;

public class FachadaRequisicoes {
	ITrequeste request;
	
	public MoedaDTO recuperarDolar() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoDolar();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarBCash() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoBCash();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarBitCoin() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoBitCoin();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	public MoedaDTO recuperarDolarCan() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoDolarCan();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarEthereum() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoEthereum();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarEuro() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoEuro();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarLibra() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoLibra();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarLiteCoin() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoLiteCoin();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	public MoedaDTO recuperarXRP() {
		MoedaDTO moeda = new MoedaDTO();
		request = new RequisicaoXRP();
		try {
		moeda.setValor(Double.parseDouble(request.consultarValor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moeda;
		
	}
	
	public MoedaDTO recuperarValor(MoedaDTO dto) {
		switch(dto.getNome()){
			case "Dolar":
				return recuperarDolar();
			
			case "DolarCan":
				return recuperarDolarCan();
			
			case "BCash":
				return recuperarBCash();
			
			case "BitCoin":
				return recuperarBitCoin();
			
			case "Ethereum":
				return recuperarEthereum();
			
			case "Euro":
				return recuperarEuro();
			
			case "Libra":
				return recuperarLibra();
			
			case "LiteCoin":
				return recuperarLiteCoin();
			
			case "XRP":
				return recuperarXRP();
			
		}
		return null;
	}
	
	
	public ValorAtualDTO recuperarRequisicoes() {
		String[] requisicoes = new String[9];
		requisicoes[0] = String.valueOf(this.recuperarBCash().getValor());
		requisicoes[1] = String.valueOf(this.recuperarBitCoin().getValor());
		requisicoes[2] = String.valueOf(this.recuperarDolar().getValor());
		requisicoes[3] = String.valueOf(this.recuperarDolarCan().getValor());
		requisicoes[4] = String.valueOf(this.recuperarEthereum().getValor());
		requisicoes[5] = String.valueOf(this.recuperarEuro().getValor());
		requisicoes[6] = String.valueOf(this.recuperarLibra().getValor());
		requisicoes[7] = String.valueOf(this.recuperarLiteCoin().getValor());
		requisicoes[8] = String.valueOf(this.recuperarXRP().getValor());
		
		ValorAtualDTO dto = new ValorAtualDTO();
		
		dto.setBCash(requisicoes[0]);
		dto.setBitCoin(requisicoes[1]);
		dto.setDolar(requisicoes[2]);
		dto.setDolarCan(requisicoes[3]);
		dto.setEthereum(requisicoes[4]);
		dto.setEuro(requisicoes[5]);
		dto.setLibra(requisicoes[6]);
		dto.setLiteCoin(requisicoes[7]);
		dto.setXRP(requisicoes[8]);
		
		return dto;
	}
}
