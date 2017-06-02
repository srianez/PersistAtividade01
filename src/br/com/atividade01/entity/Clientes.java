package br.com.atividade01.entity;

public class Clientes {

	private Integer idcliente;
	private String nome;
	private String email;

	public Clientes(){
		
	}
	
	public Clientes(Integer idcliente, String nome, String email) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.email = email;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
