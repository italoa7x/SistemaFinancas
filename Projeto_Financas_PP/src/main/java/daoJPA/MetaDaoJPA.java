package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import dto.MetaDTO;

public class MetaDaoJPA extends FactoryEntity implements ITmeta{
	private EntityManager entidade;
	
	public boolean salvar(MetaDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao salvar Meta. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	public MetaDTO listar() throws Exception {
		ArrayList<MetaDTO> lista;
		MetaDTO metas = new MetaDTO();
		entidade = super.getIntity();
		try {
			lista = (ArrayList<MetaDTO>) entidade.createQuery("from MetaDTO m").getResultList();
			metas.setTodasMetas(lista);
		}catch(Exception e) {
			throw new Exception();
		}
		return metas;
	}

	public boolean excluir(MetaDTO obj) throws Exception {
		entidade = super.getIntity();
		try {
			entidade.getTransaction().begin();
			entidade.remove(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao excluir meta. " + e.getMessage());
		}
	}

	public MetaDTO atualizar(MetaDTO novo) throws Exception {
		entidade = super.getIntity();
		try {
			entidade.getTransaction().begin();
			novo = entidade.merge(novo);
			entidade.getTransaction().commit();
			return novo;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro o atualizar meta. " + e.getMessage());
		}
	}

	

}
