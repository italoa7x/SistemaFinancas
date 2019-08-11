package daoRelacional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import bd.ConnectionFactory;
import dto.MetaDTO;
import dto.UsuarioDTO;
import model.Usuario;

public class MetaDAO implements ITmeta{
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public MetaDAO() {
		// TODO Auto-generated constructor stub
		try {
			con = ConnectionFactory.getInstance().conectar();
		} catch (Exception e) {
			
		}
	}
	
	public int salvar(MetaDTO obj) throws Exception {
		java.sql.Date data_ini = new java.sql.Date (obj.getData_inicio().getTime());
		java.sql.Date data_fim = new java.sql.Date (obj.getData_fim().getTime());
		try {
			pst = con.prepareStatement("INSERT INTO meta (id_usuario, nome, data_inicio,data_fim,valor) VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, obj.getUsuario().getId());
			pst.setString(2, obj.getNome());
			pst.setDate(3, data_ini);
			pst.setDate(4, data_fim);
			pst.execute();
			rs = pst.getGeneratedKeys();
			while(rs.next()) {
				return rs.getInt("id");
			}
		}catch(Exception e) {
			throw new Exception("Erro ao salvar meta. " + e.getMessage());
		}
		return -1;
	}

	public MetaDTO listar() throws Exception {
		MetaDTO retorno = new MetaDTO();
		ArrayList<MetaDTO> lista = new ArrayList<MetaDTO>();	
		
		try {
			pst = con.prepareStatement("SELECT *FROM meta");
			rs = pst.executeQuery();
			while(rs.next()){
				MetaDTO m = new MetaDTO();
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setId(rs.getInt("id_usuario"));
				m.setData_fim(rs.getDate("data_fim"));
				m.setData_inicio(rs.getDate("data_inicio"));
				m.setId(rs.getInt("id"));
				m.setNome(rs.getString("nome"));
				m.setUsuario(usuario);
				lista.add(m);
			}
			retorno.setTodasMetas(lista);
			return retorno;
		}catch(Exception e) {
			throw new Exception("Erro ao listar metas. " + e.getMessage());
		}
	}

	public boolean excluir(int id) throws Exception {
		try {
			pst = con.prepareStatement("DELETE FROM meta WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao excluir meta. " + e.getMessage());
		}
	}

	public boolean atualizar(MetaDTO novo) throws Exception {
		java.sql.Date data_fim = new java.sql.Date (novo.getData_fim().getTime());
		try {
			pst = con.prepareStatement("UPDATE meta set nome = ?, data_fim = ? WHERE id = ?");
			pst.setString(1, novo.getNome());
			pst.setDate(2, data_fim);
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar meta. " + e.getMessage());
		}
	}

}
