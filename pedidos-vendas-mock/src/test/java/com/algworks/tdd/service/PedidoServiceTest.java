package com.algworks.tdd.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.algworks.tdd.email.NotificadorEmail;
import com.algworks.tdd.model.Pedido;
import com.algworks.tdd.model.StatusPedido;
import com.algworks.tdd.model.builder.PedidoBuilder;
import com.algworks.tdd.repository.Pedidos;
import com.algworks.tdd.sms.NotificadorSms;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PedidoServiceTest {
	private Pedido pedido;
	private PedidoService pedidoService;
	
	@Mock
	private Pedidos pedidos;

	@Mock
	private NotificadorEmail notificadorEmail;
	
	@Mock
	private NotificadorSms notificadorSms;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		List<AcaoLancamentoPedido> acoes = Arrays.asList(notificadorEmail, notificadorSms);
		pedido = new PedidoBuilder()
					.comValor(100)
						.para("Joao","joao@joao.com", "999-0000")
							.construir();
		pedidoService = new PedidoService(pedidos, acoes);
	}
	
	@Test
	public void deveCalcularOImposto() throws Exception {
		
		double imposto = pedidoService.lancarPedido(pedido);
		
		assertEquals(10, imposto, 0.0001);
	}
	
	@Test
	public void deveSalvarPedidoNoBancoDeDados() throws Exception {
		
		pedidoService.lancarPedido(pedido);
		Mockito.verify(pedidos).guardar(pedido);
		
	}
	
	@Test
	public void deveNotificarPorEmail() throws Exception {
		pedidoService.lancarPedido(pedido);
		Mockito.verify(notificadorEmail).executar(pedido);
	}
	
	@Test
	public void deveNotificarPorSms() throws Exception {
		pedidoService.lancarPedido(pedido);
		Mockito.verify(notificadorSms).executar(pedido);
	}
	
	@Test
	public void devePagarPedidoPendente() throws Exception {
		Long codigoPedido = 135L;
		Pedido pedidoPendente = new Pedido();
		pedidoPendente.setStatus(StatusPedido.PENDENTE);
		Mockito.when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);
		Pedido pedidoPago = pedidoService.pagar(codigoPedido);
		assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
	}
	
	@Test(expected = PedidoInvalidoException.class)
	public void deveNegarPagamento() throws Exception {
		Long codigoPedido = 135L;
		Pedido pedidoPendente = new Pedido();
		pedidoPendente.setStatus(StatusPedido.PAGO);
		Mockito.when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);
		Pedido pedidoPago = pedidoService.pagar(codigoPedido);
		assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
	}
}
