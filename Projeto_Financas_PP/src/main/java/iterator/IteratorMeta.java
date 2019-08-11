package iterator;

import java.util.ArrayList;

import dto.MetaDTO;

public class IteratorMeta implements Iterator{
	private ArrayList<MetaDTO> lista;
	private int quantidade = 0;
	
	public IteratorMeta(ArrayList<MetaDTO> l) {
		lista = l;
	}
	public Object next() {
		MetaDTO m = lista.get(quantidade);
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
