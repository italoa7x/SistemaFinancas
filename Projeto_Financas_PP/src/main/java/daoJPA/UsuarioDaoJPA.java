package daoJPA;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import antlr.collections.List;
import dto.UsuarioDTO;

public class UsuarioDaoJPA extends FactoryEntity implements ITusuario {

	private EntityManager entidade;

	public boolean salvar(UsuarioDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.persist(obj);
			entidade.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			entidade.close();
		}
	}

	public UsuarioDTO excluir(UsuarioDTO obj) throws Exception {
		UsuarioDTO achado = null;
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			entidade.remove(achado);
			entidade.getTransaction().commit();

		} catch (Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			entidade.close();
		}
		return achado;
	}

	public UsuarioDTO atualizar(UsuarioDTO obj) throws Exception {
		entidade = super.getIntity();
		entidade.getTransaction().begin();
		try {
			obj = entidade.merge(obj);
			entidade.getTransaction().commit();

		} catch (Exception e) {
			entidade.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			entidade.close();
		}
		return obj;
	}

	public UsuarioDTO listar() throws Exception {
		UsuarioDTO retorno = new UsuarioDTO();
		ArrayList<UsuarioDTO> lista;
		entidade = super.getIntity();
		try {
			lista = (ArrayList<UsuarioDTO>) entidade.createQuery("from UsuarioDTO").getResultList();
			retorno.setUsuariosCadastrados(lista);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	public UsuarioDTO buscar(UsuarioDTO obj) throws Exception {
		UsuarioDTO retorno = null;
		entidade = super.getIntity();
		try {
			retorno = entidade.find(UsuarioDTO.class, obj.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	public UsuarioDTO logar(UsuarioDTO usuario) throws Exception {
		entidade = super.getIntity();
		UsuarioDTO encontrado = null;
		String jpql = "select u from UsuarioDTO u where u.email = :email and u.senha = :senha";
		TypedQuery<UsuarioDTO> query = entidade.createQuery(jpql, UsuarioDTO.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		try {
			encontrado = query.getSingleResult();
			return encontrado;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public UsuarioDTO buscarPorEmail(UsuarioDTO dto) throws Exception {
		entidade = super.getIntity();
		UsuarioDTO encontrado = null;
		String jpql = "select u from UsuarioDTO u where u.email = :email";
		TypedQuery<UsuarioDTO> query = entidade.createQuery(jpql, UsuarioDTO.class);
		query.setParameter("email", dto.getEmail());
		try {
			encontrado = query.getSingleResult();
			return encontrado;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
