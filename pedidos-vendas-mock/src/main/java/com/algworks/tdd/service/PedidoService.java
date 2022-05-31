package com.algworks.tdd.service;

import com.algworks.tdd.email.NotificadorEmail;
import com.algworks.tdd.model.Pedido;
import com.algworks.tdd.model.StatusPedido;
import com.algworks.tdd.repository.Pedidos;
import com.algworks.tdd.sms.NotificadorSms;
import java.util.List;

public class PedidoService {

	private Pedidos pedidos;
	
	
	private List<AcaoLancamentoPedido> acoes;
	
	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
		this.pedidos = pedidos;
		this.acoes = acoes;
	}



	public double lancarPedido(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
	
		pedidos.guardar(pedido);
		for(AcaoLancamentoPedido acao : acoes) {
			acao.executar(pedido);
		}

		return imposto;
	}



	public Pedido pagar(Long codigoPedido) {
		Pedido pedido = pedidos.buscarPeloCodigo(codigoPedido);
		if(!pedido.getStatus().equals(StatusPedido.PENDENTE))
			throw new PedidoInvalidoException();
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}

}
