package com.algworks.tdd.sms;


import com.algworks.tdd.model.Pedido;
import com.algworks.tdd.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido{
	public void executar(Pedido pedido) {
		System.out.println("Enviando o sms...");
	}
}
