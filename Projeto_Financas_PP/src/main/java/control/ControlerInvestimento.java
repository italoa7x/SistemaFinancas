package control;

import dto.InvestimentoDTO;
import model.Investimento;
import model.Investimento;

public class ControlerInvestimento {

	private Investimento investimento;

	public ControlerInvestimento() {
		investimento = new Investimento();
	}

	public boolean salvar(InvestimentoDTO dto) throws Exception {

		return investimento.salvar(dto);

	}

	public boolean excluir(InvestimentoDTO dto) throws Exception {
		
			return investimento.excluir(dto);
		
	}

	public InvestimentoDTO atualizar(InvestimentoDTO dto) throws Exception {

		return investimento.atualizar(dto);

	}

	public InvestimentoDTO listar() throws Exception {

		return investimento.listar();

	}

	public InvestimentoDTO buscar(InvestimentoDTO dto) throws Exception {
		
			return investimento.buscar(dto);
		
	}

//	public InvestimentoDTO logar(InvestimentoDTO dto) throws Exception {
//		
//			return investimento.logar(dto);
//		
//	}
	
	public InvestimentoDTO calcularMargemDeLucro(InvestimentoDTO dto) {
		return investimento.calcularMargemDeLucro(dto);
	}

}
