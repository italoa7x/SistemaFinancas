package factory;

import control.ControlerMeta;
import dto.MetaDTO;
import model.Meta;

public class FactoryMeta implements ITfabrica{

	public Object gerar(String tipo) {
		if(tipo.equalsIgnoreCase("control")) {
			return new ControlerMeta();
		}else if(tipo.equalsIgnoreCase("dto")) {
			return new MetaDTO();
		}else if(tipo.equalsIgnoreCase("model")) {
			return new Meta();
		}
		return null;
	}

}
