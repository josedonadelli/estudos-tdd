package com.algworks.desconto;

public class CalculadoraDescontoTerceiraFaixa extends CalculadoraDaFaixaDeDesconto{

	
	
	public CalculadoraDescontoTerceiraFaixa(CalculadoraDaFaixaDeDesconto proximo) {
		super(proximo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double calcular(double valorTotal) {
		
		if(valorTotal > 1000) {
			return valorTotal * 0.08;
		}
		return -1;
	}
}
