package model;

import java.util.Date;

import daoJPA.ITlucro;
import daoJPA.LucroDaoJPA;
import dto.LucroDTO;

public class Lucro {
	private double valor;
	private Date data;
	
	private ITlucro lucrodao;
	
	public Lucro() {
		lucrodao = new LucroDaoJPA();
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
	
	public boolean salvar(LucroDTO obj) throws Exception{
		return lucrodao.salvar(obj);
	}
	
	public LucroDTO listar() throws Exception {
		return lucrodao.listar();
	}
}
