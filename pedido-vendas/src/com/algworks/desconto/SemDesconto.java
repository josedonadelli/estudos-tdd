package com.algworks.desconto;

public class SemDesconto extends CalculadoraDaFaixaDeDesconto{

	public SemDesconto(CalculadoraDaFaixaDeDesconto proximo) {
		super(proximo);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	protected double calcular(double valorTotal) {
		return 0;
	}
}
