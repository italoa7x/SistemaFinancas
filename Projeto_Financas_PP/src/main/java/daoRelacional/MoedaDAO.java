package daoRelacional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bd.ConnectionFactory;
import dto.MoedaDTO;

public class MoedaDAO implements ITmoeda {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public MoedaDAO() {
		// TODO Auto-generated constructor stub
		try {
			con = ConnectionFactory.getInstance().conectar();
		} catch (Exception e) {
			
		}
	}
	
	public boolean salvar(MoedaDTO obj) throws Exception {
		try {
			pst = con.prepareStatement("INSERT INTO meoda (nome,valor) VALUES (?,?)");
			pst.setString(1, obj.getNome());
			pst.setDouble(2, obj.getValor());
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao salvar moeda. " + e.getMessage());
		}
	}

	public MoedaDTO listar() throws Exception {
		MoedaDTO retorno = new MoedaDTO();
		ArrayList<MoedaDTO> lista = new ArrayList<MoedaDTO>();
		try {
			pst = con.prepareStatement("SELECT *FROM moeda");
			rs = pst.executeQuery();
			while(rs.next()) {
				MoedaDTO m = new MoedaDTO();
				m.setNome(rs.getString("nome"));
				m.setValor(rs.getDouble("valor"));
				m.setId(rs.getInt("id"));
				lista.add(m);
			}
			retorno.setTodasMoedas(lista);
			return retorno;
		}catch(Exception e) {
			throw new Exception("Erro ao listar moedas. "+e.getMessage());
		}
	}

	public boolean atualizar(MoedaDTO novo) throws Exception {
		try {
			pst = con.prepareStatement("UPDATE moeda SET nome = ?, valor = ? WHERE id = ?");
			pst.setString(1, novo.getNome());
			pst.setDouble(2, novo.getValor());
			pst.setInt(3, novo.getId());
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar moeda. " + e.getMessage());
		}
	}

	public boolean excluir(int id) throws Exception {
		try {
			pst = con.prepareStatement("DELETE FROM moeda WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao excluir moeda. " + e.getMessage());
		}
	}

}
