package com.algworks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class PedidoVendaTest {
	
	private PedidoBuilder pedido;
	
	@Before
	public void setup(){
		pedido = new PedidoBuilder();
	}
	
	@Test
	public void deveCriarUmPedido() throws Exception {	 
	}
	
	private void assertResumoDoPedido(double valorTotal, double desconto) {
 		ResumoPedido resumoPedido = this.pedido.construir().resumo();
		//assertEquals(valorTotal, resumo.getValorTotal(), 0.0001);
		//assertEquals(desconto, resumo.getDesconto(), 0.0001);
 		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	}
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoDoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		//pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		pedido.comItem(5.0, 5);
		assertResumoDoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		//pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
		//pedido.adicionarItem(new ItemPedido("Creme dental", 7.0, 3));
		pedido.comItem(3.0, 3) // Pedido com item (3.0, 3) e com item (7.0,3) e com item(xpto, xpto)...
			.comItem(7.0, 3);// Pode-se encadear tanto quanto quiser
		
		assertResumoDoPedido(30, 0);
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		//pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));
		pedido.comItem(20.0,20);
		assertResumoDoPedido(400.0, 16.0);
		
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		//pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		//pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		pedido.comItem(15.0,30)
			.comItem(15, 30);
		assertResumoDoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicaarDescontoNa3aFaixa() throws Exception {
		//pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		//pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		//pedido.adicionarItem(new ItemPedido("Creme", 10.0, 30));
		pedido.comItem(15.0,30)
			.comItem(15, 30)
				.comItem(10.0,30);
		
		assertResumoDoPedido(1200.0, 96.0);
	}
	
	@Test(expected = QuantidadeItensInvalidaException.class)
	public void naoAceitarPedidosComItensComQuantidadesNegativas() throws Exception {
		pedido.comItem(0.0, -10);
		
	}
	
	
	
}
