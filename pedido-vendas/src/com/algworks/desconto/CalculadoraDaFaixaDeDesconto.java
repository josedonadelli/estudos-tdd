package com.algworks.desconto;

public abstract class CalculadoraDaFaixaDeDesconto {
	private CalculadoraDaFaixaDeDesconto proximo;

	public CalculadoraDaFaixaDeDesconto(CalculadoraDaFaixaDeDesconto proximo) {
		this.proximo = proximo;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		if(desconto == -1) 
			return proximo.desconto(valorTotal);
		
		return desconto;
		
	}
	
	protected abstract double calcular(double valorTotal);
}
