package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import dto.InvestimentoDTO;

public class InvestimentoDaoJPA extends FactoryEntity implements ITinvestimento{
	private EntityManager entidade;
	
	public boolean salvar(InvestimentoDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao salvar investimento. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	public InvestimentoDTO atualizar(InvestimentoDTO novo) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			novo = entidade.merge(novo);
			entidade.getTransaction().commit();
			return novo;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao atualizar investimento. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	public InvestimentoDTO listar() throws Exception {
		ArrayList<InvestimentoDTO> lista;
		InvestimentoDTO investimentos = new InvestimentoDTO();
		entidade = super.getIntity();
		try {
			lista = (ArrayList<InvestimentoDTO>) entidade.createQuery("from InvestimentoDTO i").getResultList();
			investimentos.setTodosInvetismento(lista);
			return investimentos;
		}catch(Exception e) {
			throw new Exception("Erro ao buscar investimentos. " + e.getMessage());
		}
	}

	public InvestimentoDTO buscar(InvestimentoDTO obj) throws Exception {
		try {
			entidade = super.getIntity();
			return entidade.find(InvestimentoDTO.class, obj.getId());
		}catch(Exception e) {
			throw new Exception("Não foi possível buscar o investimento. " + e.getMessage());
		}
	}

	public boolean excluir(InvestimentoDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.remove(obj);
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception();
		}
	}

}
