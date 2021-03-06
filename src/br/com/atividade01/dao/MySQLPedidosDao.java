package br.com.atividade01.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.atividade01.entity.Pedidos;

public class MySQLPedidosDao implements PedidosDao {

	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;

	@Override
	public Pedidos incluirPedido(Pedidos pedido) throws Exception {

		try {
			cn = MySQLDaoFactory.criarConexao();

			String sql = "INSERT INTO PEDIDOS (IDCLIENTE, DATA, DESCRICAO, VALOR) VALUES (?,?,?,?)";

			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, pedido.getIdcliente());
			stmt.setDate(2, new Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.execute();

			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				pedido.setIdpedido(rs.getInt(1));
				System.out.println("Pedido cadastrado: " + pedido.getIdpedido() + " " + pedido.getDescricao() + " para cliente " + pedido.getIdcliente());
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return pedido;
	}

	
	@Override
	public List<Pedidos> listarPedidos(int idCliente) throws Exception {
		
		List<Pedidos> pedidos = new ArrayList<>();

		try {
			cn = MySQLDaoFactory.criarConexao();

			String sql = "SELECT IDPEDIDO, DATA, DESCRICAO, VALOR FROM PEDIDOS WHERE IDCLIENTE=?";
			System.out.println("Parse da QUERY OK. Listar pedidos do cliente: " + idCliente);
			
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				pedidos.add(new Pedidos(rs.getInt("IDPEDIDO"), 
						                idCliente, 
						                rs.getDate("DATA"), 
						                rs.getString("DESCRICAO"),
						                rs.getDouble("VALOR")));

			}
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}

		return pedidos;

	}
//===================
	@Override
	public Double totalPedidos() throws Exception {
		
        Double total = new Double(0);
        
		try {
			cn = MySQLDaoFactory.criarConexao();

			String sql = "SELECT SUM(VALOR) AS TOTAL FROM PEDIDOS";
			
			stmt = cn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				total = rs.getDouble("TOTAL");
				break;
			}
			
			return total;
			
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}


	}

	
	
//=================	
}