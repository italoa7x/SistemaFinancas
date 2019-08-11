package factory;

import control.ControlerUsuario;
import dto.UsuarioDTO;
import model.Usuario;

public class FactoryUsuario implements ITfabrica{

	
	public Object gerar(String tipo) {
		if(tipo.equalsIgnoreCase("control")) {
			return new ControlerUsuario();
		}else if(tipo.equalsIgnoreCase("dto")){
			return new UsuarioDTO();
		}else if(tipo.equalsIgnoreCase("model")) {
			return new Usuario();
		}
		throw new RuntimeException();
	}

}
