package com.algworks.desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculadoraDaFaixaDeDesconto{

	public CalculadoraDescontoSegundaFaixa(CalculadoraDaFaixaDeDesconto proximo) {
		super(proximo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 800 && valorTotal <= 1000) {
			return valorTotal * 0.06;
		}
		return -1;
	}
}
