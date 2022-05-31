package com.algworks.tdd.repository;

import com.algworks.tdd.model.Pedido;

public class Pedidos {
	
	public void guardar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
	}
	
	public Pedido buscarPeloCodigo(Long codigo) {
		return new Pedido();
	}
}
