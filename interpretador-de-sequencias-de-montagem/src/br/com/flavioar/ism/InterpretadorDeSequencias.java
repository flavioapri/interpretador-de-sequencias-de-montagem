package br.com.flavioar.ism;

import java.util.List;

import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.logica.ComparadorDeInformacoes;

public class InterpretadorDeSequencias {

	public static List<Sequencia> interpretarSequencias(List<Sequencia> sequenciasConstruidas) {
		
		for (Sequencia sequencia : sequenciasConstruidas) {			
			ComparadorDeInformacoes.compararTipoDeCabina(sequencia);
			ComparadorDeInformacoes.compararMaterial(sequencia);
			ComparadorDeInformacoes.compararRevestimentoLateral(sequencia);
			ComparadorDeInformacoes.compararRevestimentoTraseiro(sequencia);
			ComparadorDeInformacoes.compararCodesRelevantes(sequencia);
			ComparadorDeInformacoes.compararChicote(sequencia);
			ComparadorDeInformacoes.verificarCabinaCompacta(sequencia);			
		}
		return sequenciasConstruidas;
	}
}
