package daoRelacional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bd.ConnectionFactory;
import dto.UsuarioDTO;

public class UsuarioDAO implements ITusuario {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;

	public UsuarioDAO() {
		try {
			con = ConnectionFactory.getInstance().conectar();
		} catch (Exception e) {

		}
	}

	public boolean salvar(UsuarioDTO obj) throws Exception {
		try {
			pst = con.prepareStatement("INSERT INTO usuario (nome,cpf,email,telefone) VALUES (?,?,?,?)");
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getCpf());
			pst.setString(3, obj.getEmail());
			pst.setString(4, obj.getTelefone());
			pst.execute();
			return true;
		} catch (Exception e) {
			throw new Exception("Erro ao salvar usuario. " + e.getMessage());
		}
	}

	public boolean excluir(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atualizar(UsuarioDTO obj) throws Exception {
		try {
			pst = con.prepareStatement("UPDATE usuario SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id = ?");
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getCpf());
			pst.setString(3, obj.getEmail());
			pst.setString(4, obj.getTelefone());
			pst.setInt(5, obj.getId());
			pst.execute();
			return true;
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar usuario. " + e.getMessage());
		}
	}

	public UsuarioDTO listar() throws Exception {
		UsuarioDTO retorno = new UsuarioDTO();
		ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		
		try {
			pst = con.prepareStatement("SELECT *FROM usuario");
			rs = pst.executeQuery();
			while(rs.next()) {
				UsuarioDTO user = new UsuarioDTO();
				user.setNome(rs.getString("nome"));
				user.setCpf(rs.getString("cpf"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
				lista.add(user);
			}
			retorno.setUsuariosCadastrados(lista);
			return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar usuario. " + e.getMessage());
		}
	}

	public UsuarioDTO logar(UsuarioDTO obj) throws Exception {
		UsuarioDTO retorno = null;
		try {
			pst = con.prepareStatement("SELECT *FROM usuario WHERE email = ? AND senha = ?");
			pst.setString(1, obj.getEmail());
			pst.setString(2, obj.getSenha());
			rs = pst.executeQuery();
			while(rs.next()) {
				retorno = new UsuarioDTO();
				retorno.setNome(rs.getString("nome"));
				retorno.setCpf(rs.getString("cpf"));
				retorno.setEmail(rs.getString("email"));
				retorno.setId(rs.getInt("id"));
				retorno.setSenha(rs.getString("senha"));
			}
			return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao logar no sistema. " + e.getMessage());
		}
	}

}
