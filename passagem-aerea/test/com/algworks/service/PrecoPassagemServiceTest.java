package com.algworks.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.algworks.model.Passageiro;
import com.algworks.model.TipoPassageiro;
import com.algworks.model.Voo;

public class PrecoPassagemServiceTest {
	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		 precoPassagemService = new PrecoPassagemService();		
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
		
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo","Rio de Janeiro",100.00);
		assertValorPassagem(passageiro, voo, 90.0);	
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo","Rio de Janeiro",600.00);
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo","Rio de Janeiro",100.00);
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo","Rio de Janeiro",1000.00);
		assertValorPassagem(passageiro, voo, 900.0);
	}
}
