package factory;

import control.ControlerInvestimento;
import dto.InvestimentoDTO;
import model.Investimento;

public class FactoryInvestimento implements ITfabrica{

	public Object gerar(String tipo) {
		if(tipo.equalsIgnoreCase("control")) {
			return new ControlerInvestimento();
		}else if(tipo.equalsIgnoreCase("dto")) {
			return new InvestimentoDTO();
		}else if(tipo.equalsIgnoreCase("model")) {
			return new Investimento();
		}
		return null;
	}

	
}
