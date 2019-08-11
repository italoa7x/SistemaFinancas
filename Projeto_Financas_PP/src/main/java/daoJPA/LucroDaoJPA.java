package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import dto.LucroDTO;

public class LucroDaoJPA extends FactoryEntity implements ITlucro{
	private EntityManager entidade;
	
	@Override
	public boolean salvar(LucroDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao cadastrar o lucro. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	@Override
	public LucroDTO listar() throws Exception {
		LucroDTO retorno = new LucroDTO();
		ArrayList<LucroDTO> lucros = null;
		try {
			lucros = (ArrayList<LucroDTO>) entidade.createQuery("from LucroDTO l").getResultList();
			retorno.setTotalLucros(lucros);
		}catch(Exception e) {
			throw new Exception("Erro ao listar lucros. " + e.getMessage());
		}finally {
			entidade.close();
		}
		return retorno;
	}

}
