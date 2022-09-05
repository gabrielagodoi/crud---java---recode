package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Pessoa;

public class PessoaDAO {
	
	public void save (Pessoa pessoa) {
		String sql = "INSERT INTO pessoas (nome, idade, etnia)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3,pessoa.getEtnia());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	public void removeById (int id) {
		String sql = "DELETE FROM pessoas where id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,id);
			
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void update (Pessoa pessoa) {
		String sql = "UPDATE pessoa set nome = ?, idade = ?, etnia = ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3,pessoa.getEtnia());
			
			pstm.setInt(4, pessoa.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	public List<Pessoa> getPessoas(){
		
		String sql = "SELECT * FROM pessoas";
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
		while(rset.next()) {
			Pessoa pessoa = new Pessoa();
			
		pessoa.setId(rset.getInt("id"));
		
		pessoa.setNome(rset.getString("nome"));
		
		pessoa.setIdade(rset.getInt("idade"));
		
		pessoa.setEtnia(rset.getString("etnia"));
		
		pessoas.add(pessoa);
		}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if (rset != null) {
				rset.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pessoas;	
	}

}
