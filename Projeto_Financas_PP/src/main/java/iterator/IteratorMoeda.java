package iterator;

import java.util.ArrayList;

import dto.MoedaDTO;

public class IteratorMoeda implements Iterator{
	private ArrayList<MoedaDTO> lista;
	private int quantidade = 0;
	
	public IteratorMoeda(ArrayList<MoedaDTO> l ) {
		lista = l;
	}
	public Object next() {
		MoedaDTO m = lista.get(quantidade);
		quantidade ++;
		return m;
	}

	public boolean hasNext() {
		if(quantidade >= lista.size() || lista.get(quantidade) == null) {
			return false;
		}else {
			return true;
		}
	}

}
