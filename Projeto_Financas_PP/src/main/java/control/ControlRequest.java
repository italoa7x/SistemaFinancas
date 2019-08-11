package control;

import dto.MoedaDTO;
import model.requisicoes.FachadaRequisicoes;

public class ControlRequest {
	FachadaRequisicoes fachada = new FachadaRequisicoes();
	
	
	public MoedaDTO recuperarValor(MoedaDTO dto) {
		return fachada.recuperarValor(dto);
	}
}
