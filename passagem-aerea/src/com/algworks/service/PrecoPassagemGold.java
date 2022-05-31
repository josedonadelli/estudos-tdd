package com.algworks.service;

import com.algworks.model.Passageiro;
import com.algworks.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem{
	
	@Override
	public double calcular(Voo voo) {
		if(voo.getPreco() > 500.0)
			return voo.getPreco() * 0.85;
		return  voo.getPreco()*0.9;
	}

}
