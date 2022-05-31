package com.algworks.service;

import com.algworks.model.Passageiro;
import com.algworks.model.TipoPassageiro;
import com.algworks.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		//Antes de refatorar:
		/*if(passageiro.getTipo().equals(TipoPassageiro.GOLD)) {
			if(voo.getPreco() > 500.0)
				return voo.getPreco() * 0.85;
			return  voo.getPreco()*0.9;
		}else if(passageiro.getTipo().equals(TipoPassageiro.SILVER)) {
			if(voo.getPreco() > 700.0)
				return voo.getPreco() * 0.9;
			return voo.getPreco() * 0.94;
		}*/
		
		//Depois de refatorar: 
		return passageiro.getTipo().getCalculadora().calcular(voo);
		
	}
	
}
