package com.algworks;

import java.util.ArrayList;
import java.util.List;

//import org.hamcrest.CustomTypeSafeMatcher;

import com.algworks.desconto.CalculadoraDaFaixaDeDesconto;

public class Pedido {

	
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	private CalculadoraDaFaixaDeDesconto calculadoraFaixaDeDesconto;
	
	
	
	
	public Pedido(CalculadoraDaFaixaDeDesconto calculadoraFaixaDeDesconto) {
		this.calculadoraFaixaDeDesconto = calculadoraFaixaDeDesconto;
	}

	public void validarQuantidadeItens(ItemPedido itemPedido) {
		if(itemPedido.getQtd() < 0) {
			throw new QuantidadeItensInvalidaException();
		}
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		
		validarQuantidadeItens(itemPedido);
		this.itens.add(itemPedido);
		
	}


	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQtd()).sum();
		double desconto = calculadoraFaixaDeDesconto.desconto(valorTotal);
		
		
		/*if(valorTotal > 300 && valorTotal <= 800) {
			desconto = valorTotal*0.04;
		}else if(valorTotal > 800 && valorTotal <= 1000) {
			desconto = valorTotal * 0.06;
		}else if(valorTotal > 1000) {
			desconto = valorTotal * 0.08;
		}*/
		return new ResumoPedido(valorTotal, desconto);
	}
}
