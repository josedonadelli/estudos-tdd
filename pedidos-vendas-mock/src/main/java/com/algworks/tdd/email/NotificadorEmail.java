package com.algworks.tdd.email;

import com.algworks.tdd.model.Pedido;
import com.algworks.tdd.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido{
	
	public void executar(Pedido pedido) {
		System.out.println("Enviando o e-mail...");		
	}
}	
