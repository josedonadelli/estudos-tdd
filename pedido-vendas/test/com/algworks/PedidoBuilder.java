package com.algworks;

import com.algworks.desconto.CalculadoraDaFaixaDeDesconto;
import com.algworks.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.algworks.desconto.CalculadoraDescontoSegundaFaixa;
import com.algworks.desconto.CalculadoraDescontoTerceiraFaixa;
import com.algworks.desconto.SemDesconto;

public class PedidoBuilder {
	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculadoraDaFaixaDeDesconto calculadoraFaixaDeDesconto = 
				new CalculadoraDescontoTerceiraFaixa(
						new CalculadoraDescontoSegundaFaixa(
								new CalculadoraDescontoPrimeiraFaixa(
										new SemDesconto(null))));
		instancia = new Pedido(calculadoraFaixaDeDesconto);	
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido construir(){
		return instancia;
	}
}
