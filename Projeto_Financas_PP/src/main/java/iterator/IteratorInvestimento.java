package iterator;

import java.util.ArrayList;
import java.util.List;

import dto.InvestimentoDTO;

public class IteratorInvestimento implements Iterator{
	private List<InvestimentoDTO> lista;
	private int quantidade = 0;
	
	public IteratorInvestimento(List<InvestimentoDTO> l) {
		lista = l;
	}
	public Object next() {
		InvestimentoDTO iv = lista.get(quantidade);
		quantidade++;
		return iv;
	}

	public boolean hasNext() {
		if(quantidade >= lista.size() || lista.get(quantidade) == null) {
			return false;
		}else {
			return true;
		}
	}

}
