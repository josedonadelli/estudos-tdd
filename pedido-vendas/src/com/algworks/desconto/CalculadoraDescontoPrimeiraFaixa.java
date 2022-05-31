package com.algworks.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraDaFaixaDeDesconto{

	public CalculadoraDescontoPrimeiraFaixa(CalculadoraDaFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300 && valorTotal <= 800) {
			return valorTotal * 0.04;
		}
		return -1;
	}
}
