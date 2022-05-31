package com.algworks.model;

import com.algworks.service.CalculadoraPrecoPassagem;
import com.algworks.service.PrecoPassagemGold;
import com.algworks.service.PrecoPassagemSilver;

public enum TipoPassageiro {
	GOLD(new PrecoPassagemGold()),
	SILVER(new PrecoPassagemSilver());
	
	CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem){
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadora() {
		return this.calculadoraPrecoPassagem;
	}
}
