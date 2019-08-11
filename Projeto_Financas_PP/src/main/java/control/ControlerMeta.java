
package control;

import dto.MetaDTO;
import model.Meta;
import model.Meta;
import strategy.StrategyGenerico;

public class ControlerMeta {

	private Meta meta;

	public ControlerMeta() {
		meta = new Meta();
	}

	public boolean salvar(MetaDTO dto) throws Exception {

		return meta.salvar(dto);

	}

	public boolean excluir(MetaDTO dto) throws Exception {

		return meta.excluir(dto);

	}

	public MetaDTO atualizar(MetaDTO dto) throws Exception {

		return meta.atualizar(dto);

	}

	public MetaDTO listar() throws Exception {

		return meta.listar();

	}
	
	public int metasFinalizadas() throws Exception {
		return meta.quantidadeFinalizados();
	}
//
//	public Object buscar(MetaDTO dto) throws Exception {
//	
//			return meta.buscar(dto);
//		
//	}
//
//	public Object logar(MetaDTO dto) throws Exception {
//		
//			return meta.logar(dto);
//		
//	}

}
