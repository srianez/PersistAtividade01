package br.com.atividade01.dao;

public abstract class DaoFactory {

	public abstract ClientesDao getClientesDao();

	public abstract PedidosDao getPedidosDao();

	public static DaoFactory getDaoFactory() {
		return new MySQLDaoFactory();
	}
}