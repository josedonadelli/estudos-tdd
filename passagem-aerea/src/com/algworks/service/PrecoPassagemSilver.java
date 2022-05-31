package com.algworks.service;

import com.algworks.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem{
	public double calcular(Voo voo) {
		if(voo.getPreco() > 700.0)
			return voo.getPreco() * 0.9;//Diferentge da classe PrecoPassagemSilver, aqui nao extraimos os métodos. 
		return voo.getPreco() * 0.94; // Porem, extrair seria uma boa pratica
	}
}
