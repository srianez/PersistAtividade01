package br.com.atividade01.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.atividade01.dao.ClientesDao;
import br.com.atividade01.dao.DaoFactory;
import br.com.atividade01.dao.PedidosDao;
import br.com.atividade01.entity.Clientes;
import br.com.atividade01.entity.Pedidos;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			ClientesDao clientesDao = DaoFactory.getDaoFactory().getClientesDao();
			System.out.println("1");
			List<Pedidos> listaPedidos = new ArrayList<>();
			
			Clientes cliente = new Clientes();
			cliente.setNome("Bob sponja");
			cliente.setEmail("silas@gmail.com");
			System.out.println("2");
			cliente = clientesDao.inserirCliente(cliente);
			System.out.println("3");
			
			
			PedidosDao pedidosDao = DaoFactory.getDaoFactory().getPedidosDao();	
			
			Pedidos pedido = new Pedidos();
			
			pedido.setData(new Date());
			pedido.setDescricao("Caderno do batman");
			pedido.setValor(15.80);
			
			pedido.setIdcliente(cliente.getIdcliente());
			
			System.out.println("cliente.getIdcliente() " + cliente.getIdcliente());
			
			pedidosDao.incluirPedido(pedido);
			
			System.out.println("kkkkkkkkkkk");
			
			listaPedidos = pedidosDao.listarPedidos(6);
			
			for (Pedidos pedidos : listaPedidos) {
				System.out.println(pedidos.getDescricao());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
