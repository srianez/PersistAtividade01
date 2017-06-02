package br.com.atividade01.entity;

import java.beans.Transient;
import java.util.Date;

public class Pedidos {
	
	private Integer idpedido;
	private Integer idcliente;
	private Date data;
	private String descricao;
	private Double valor;
	
	public Pedidos(){
		
	}

	public Pedidos(Integer idpedido, Integer idcliente, Date data, String descricao, Double valor){
		super();
		this.idpedido = idpedido;
		this.idcliente = idcliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
		

}
