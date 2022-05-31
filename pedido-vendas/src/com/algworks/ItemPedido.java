package com.algworks;

public class ItemPedido {
	public String descricao;
	public double valorUnitario;
	public int qtd;

	public ItemPedido(String descricao, double valorUnitario, int qtd) {
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.qtd = qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}