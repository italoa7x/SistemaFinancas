package control;

import dto.MoedaDTO;
import dto.ValorAtualDTO;
import model.Moeda;
import model.requisicoes.FachadaRequisicoes;


public class ControlerMoeda{

	private Moeda moeda;
	private FachadaRequisicoes fachada;
	
	public ControlerMoeda() {
		moeda = new Moeda();
	}
	
	public boolean salvar(MoedaDTO dto) throws Exception {
			return moeda.salvar(dto);
	}

	public boolean excluir(MoedaDTO dto) throws Exception {
			return moeda.excluir(dto);
	}

	public MoedaDTO atualizar(MoedaDTO dto) throws Exception {
			return moeda.atualizar(dto);
	}

	public MoedaDTO listar() throws Exception {
			return moeda.listar();
	}

//	public Object buscar(MoedaDTO dto) throws Exception {
//			return moeda.buscar(dto);
//	}

//	public Object logar(MoedaDTO dto) throws Exception {
//			return moeda.logar(dto);
//	}
	
	public MoedaDTO recuperarValor(MoedaDTO dto) {
		return fachada.recuperarValor(dto);
	}
	
	

}
