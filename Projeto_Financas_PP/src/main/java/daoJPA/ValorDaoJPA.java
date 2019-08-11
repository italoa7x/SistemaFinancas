package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dto.MoedaDTO;
import dto.UsuarioDTO;
import dto.ValorDTO;

public class ValorDaoJPA extends FactoryEntity implements ITvalor{
	private EntityManager entidade;
	
	
	@Override
	public boolean salvar(ValorDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception("Erro ao salvar valor. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	@Override
	public ValorDTO listar() throws Exception {
		entidade = super.getIntity();
		ValorDTO retorno = new ValorDTO();
		ArrayList<ValorDTO> valores = null;
		try {
			valores = (ArrayList<ValorDTO>) entidade.createQuery("from ValorDTO m").getResultList();
			retorno.setValoresCadastrados(valores);
			return retorno;
		}catch(Exception e) {
			throw new Exception("Erro ao consultara valores. " + e.getMessage());
		}finally {
			entidade.close();
		}
	}

	@Override
	public ValorDTO listarValores(MoedaDTO moeda) throws Exception {
		entidade = super.getIntity();
		ArrayList<ValorDTO> valores = null;
		ValorDTO valor = new ValorDTO();
		try {
			String jpql = "select v from ValorDTO v where v.id_moeda = :id";
			TypedQuery<ValorDTO> query = entidade.createQuery(jpql, ValorDTO.class);
			query.setParameter("id", moeda.getId());
	
				valores = (ArrayList<ValorDTO>) query.getResultList();
				valor.setValoresCadastrados(valores);
				return valor;
			} catch (Exception e) {
				throw new Exception("Erro ao consultar valores. ");
			}
		}
	}


