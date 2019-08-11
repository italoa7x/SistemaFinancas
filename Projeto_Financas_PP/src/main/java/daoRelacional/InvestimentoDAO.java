package daoRelacional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;

import bd.ConnectionFactory;
import dto.InvestimentoDTO;

public class InvestimentoDAO implements ITinvestimento{
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public InvestimentoDAO() {
		try {
			con = ConnectionFactory.getInstance().conectar();
		} catch (Exception e) {
			
		}
	}

	public boolean salvar(InvestimentoDTO obj) throws Exception {
		try {
			pst = con.prepareStatement("INSERT INTO investimento (status,valor,data_inicio,data_fim) VALUES (?,?,?,?)");
			pst.setString(1, obj.getStatus().name());
			pst.setDouble(2, obj.getValor());
			pst.setDate(3, (java.sql.Date) obj.getData_inicio());
			pst.setDate(4, (java.sql.Date) obj.getData_fim());
			pst.execute();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao salvar investimento. " + e.getMessage());
		}
	}

	public boolean atualizar(InvestimentoDTO novo) throws Exception {
		try {
			pst = con.prepareStatement("UPDATE investimento SET status = ?, valor = ?, data_fim = ? WHERE id = ?");
			pst.setString(1, novo.getStatus().name());
			pst.setDouble(2, novo.getValor());
			pst.setDate(3, (java.sql.Date) novo.getData_inicio());
			pst.setInt(4, novo.getId());
			pst.executeUpdate();
			return true;
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar investimento. " + e.getMessage());
		}
	}

	public InvestimentoDTO listar() throws Exception {
		InvestimentoDTO retorno = new InvestimentoDTO();
		ArrayList<InvestimentoDTO> lista = new ArrayList<InvestimentoDTO>();
		try {
			pst = con.prepareStatement("SELECT *FROM investimento");
			rs = pst.executeQuery();
			while(rs.next()) {
				InvestimentoDTO iv = new InvestimentoDTO();
				iv.setData_fim(rs.getDate("data_fim"));
				iv.setData_inicio(rs.getDate("data_inicio"));
				iv.setId(rs.getInt("id"));
				iv.setValor(rs.getDouble("valor"));
				lista.add(iv);
			}
			retorno.setTodosInvetismento(lista);
			return retorno;
		}catch(Exception e) {
			throw new Exception("Erro ao listar investimentos. " + e.getMessage());
		}
	}

}
