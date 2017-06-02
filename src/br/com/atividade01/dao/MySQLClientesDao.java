package br.com.atividade01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.atividade01.entity.Clientes;
import br.com.atividade01.entity.Pedidos;


public class MySQLClientesDao implements ClientesDao{

	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;

	@Override
	public Clientes inserirCliente(Clientes cliente) throws Exception{
		
		try {
			
			//abre a conexao
			cn = MySQLDaoFactory.criarConexao();
			
			//faz o parse do insert
			stmt = cn.prepareStatement("INSERT INTO CLIENTES (NOME, EMAIL) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			
			System.out.println("Parse do INSERT OK.");
			
			//troca os parâmetros 1: nome, 2: email
			stmt.setString(1, cliente.getNome()); 	
			stmt.setString(2, cliente.getEmail());
			
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys(); //busca o ID gerado 
			
			while (rs.next()){
				cliente.setIdcliente(rs.getInt(1));
				System.out.println("Cliente cadastrado: " + cliente.getIdcliente() + " - " + cliente.getNome());
			}
					
			
		} catch (Exception e) { 
			throw e;
		} finally { 
			cn.close();
			if (stmt != null) stmt.close();
		} 
		return cliente;
	}
	
	@Override
	public Clientes buscarCliente(int id) throws Exception{ 

		Clientes cliente = null;
		List<Pedidos> pedidos = new ArrayList<>();

		try {
			cn=MySQLDaoFactory.criarConexao();
			String sql="SELECT IDPEDIDO, DATA, DESCRICAO,VALOR FROM PEDIDOS WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()){
				pedidos.add(new Pedidos(rs.getInt("IDPEDIDO"),
						                id,
						                rs.getDate("DATA"),
						                rs.getString("DESCRICAO"), 
						                rs.getDouble("VALOR")));
			}

			sql="SELECT NOME, EMAIL FROM CLIENTES WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()){
				cliente = new Clientes(id, rs.getString("NOME"), rs.getString("EMAIL"));
			}

		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			stmt.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}

		return cliente;

	} 
}