package factory;

import control.ControlerMoeda;
import dto.MoedaDTO;
import model.Moeda;

public class FactoryMoeda implements ITfabrica{

	public Object gerar(String tipo) {
		if(tipo.equalsIgnoreCase("control")) {
			return new ControlerMoeda();
		}else if(tipo.equalsIgnoreCase("dto")) {
			return new MoedaDTO();
		}else if(tipo.equalsIgnoreCase("model")) {
			return new Moeda();
		}
		return null;
	}

}
