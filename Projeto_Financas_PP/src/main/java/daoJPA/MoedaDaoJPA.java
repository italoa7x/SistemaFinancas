package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import dto.MoedaDTO;

public class MoedaDaoJPA extends FactoryEntity implements ITmoeda {
	private EntityManager entidade;
	
	public boolean salvar(MoedaDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao salvar moeda. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	public MoedaDTO listar() throws Exception {
		ArrayList<MoedaDTO> lista;
		MoedaDTO moedas = new MoedaDTO();
		entidade = super.getIntity();
		try {
			lista = (ArrayList<MoedaDTO>) entidade.createQuery("from MoedaDTO mt").getResultList();
			moedas.setTodasMoedas(lista);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar moedas. " + e.getMessage());
		}
		return moedas;
	}

	public MoedaDTO atualizar(MoedaDTO novo) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			novo = entidade.merge(novo);
			entidade.getTransaction().commit();
		}catch(Exception e ) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao atualizar dados. " + e.getMessage());
		}
		return novo;
	}

	public boolean excluir(MoedaDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.remove(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao excluir moeda. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

}
