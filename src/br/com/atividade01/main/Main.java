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
			
			//Cadastro do cliente
			ClientesDao clientesDao = DaoFactory.getDaoFactory().getClientesDao();	
			
			Clientes cliente = new Clientes();
			cliente.setNome("Pipipitchu");
			cliente.setEmail("hayeahyeah@gmail.com");
			
			cliente = clientesDao.inserirCliente(cliente);	
			
//===============================================================================================
			//Cadastro do pedido
			
			List<Pedidos> listaPedidos = new ArrayList<>();
			//List<Pedidos> totalPedidos = new ArrayList<>();
			Double totalPedidos;
	
			PedidosDao pedidosDao = DaoFactory.getDaoFactory().getPedidosDao();	
			
			Pedidos pedido = new Pedidos();
			
			pedido.setData(new Date());
			pedido.setDescricao("Boné do batman");
			pedido.setValor(19.80);
			
			
			//seta o código do cliente cadastrado anteriormente (FK)
			pedido.setIdcliente(cliente.getIdcliente());

			pedidosDao.incluirPedido(pedido);
			
			listaPedidos = pedidosDao.listarPedidos(cliente.getIdcliente());
			totalPedidos = pedidosDao.totalPedidos();
			
			//Exibe os dados do pedido que foi cadastrado anteriormente. Dados carregados através do SELECT
			for (Pedidos pedidos : listaPedidos) {
				System.out.println("Pedido Efetuado com o item: "+ pedidos.getDescricao() +
						           " com valor de: " + pedidos.getValor()+
						           ". Data da compra: "+ pedidos.getData());
			}
			
		    System.out.println("Valor total dos pedidos: " + totalPedidos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
