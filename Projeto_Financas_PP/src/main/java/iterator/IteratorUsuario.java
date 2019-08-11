package iterator;

import java.util.ArrayList;

import dto.UsuarioDTO;
import model.Usuario;

public class IteratorUsuario implements Iterator {
	private ArrayList<UsuarioDTO> lista;
	private int quantidade = 0;

	public IteratorUsuario(ArrayList<UsuarioDTO> l) {
		lista = l;
	}

	public Object next() {
		UsuarioDTO u = lista.get(quantidade);
		quantidade++;
		return u;
	}

	public boolean hasNext() {
		if (lista.size() >= quantidade || lista.get(quantidade) == null) {
			return false;
		} else {
			return true;
		}
	}

}
