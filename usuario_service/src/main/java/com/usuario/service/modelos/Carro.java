package com.usuario.service.modelos;

public class Carro {
	
	private String Marca;
	private String Modelo;
	private int usuarioId;

	public String getMarca() {
		return Marca;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public Carro() {
		super();
	}

}
