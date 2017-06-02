package br.com.atividade01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoFactory extends DaoFactory{
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/scjperat01?autoReconnect=true&useSSL=false";//"jdbc:mysql://localhost:3306/sjcperat01";
	
	public static Connection criarConexao() throws Exception{ 
		
		try {
			
			return DriverManager.getConnection(URL,"root","papainoel123");

		} catch (SQLException ex) {

		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
		
		
		
	}

	@Override
	public ClientesDao getClientesDao() {
		return new MySQLClientesDao();
	}

	@Override
	public PedidosDao getPedidosDao() {
		return new MySQLPedidosDao();
	}
}