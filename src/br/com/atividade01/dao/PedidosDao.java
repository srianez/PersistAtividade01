package br.com.atividade01.dao;


import java.util.List;

import br.com.atividade01.entity.Pedidos;

public interface PedidosDao {
	Pedidos incluirPedido(Pedidos pedido) throws Exception; 
	List<Pedidos> listarPedidos(int idCliente) throws Exception; 
	Double totalPedidos() throws Exception;
}