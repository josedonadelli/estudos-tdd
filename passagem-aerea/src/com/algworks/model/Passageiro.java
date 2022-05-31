package com.algworks.model;

public class Passageiro {
	private String name;
	private TipoPassageiro tipo;
	public Passageiro(String name, TipoPassageiro tipo) {
		super();
		this.name = name;
		this.tipo = tipo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TipoPassageiro getTipo() {
		return tipo;
	}
	 
	public void setTipo(TipoPassageiro tipo) {
		this.tipo = tipo;
	}
	
}
