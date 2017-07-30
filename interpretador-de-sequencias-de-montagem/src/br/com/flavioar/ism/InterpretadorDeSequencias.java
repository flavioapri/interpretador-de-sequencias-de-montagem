package br.com.flavioar.ism;

import java.util.List;

import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.logica.ComparadorDeInformacoes;

public class InterpretadorDeSequencias {

	public static List<Sequencia> interpretarSequencias(List<Sequencia> sequenciasConstruidas) {
		
		for (Sequencia sequencia : sequenciasConstruidas) {
			ComparadorDeInformacoes.compararMaterial(sequencia);
			ComparadorDeInformacoes.compararRevestimentoLateral(sequencia);
			ComparadorDeInformacoes.compararRevestimentoTraseiro(sequencia);
			ComparadorDeInformacoes.compararCodesRelevantes(sequencia);			
			ComparadorDeInformacoes.reflection(sequencia, "TipoDeCabina", "setTipoDeCabina");
			ComparadorDeInformacoes.reflection(sequencia, "Chicotes", "setChicote");
			ComparadorDeInformacoes.verificarCabinaCompacta(sequencia);
			ComparadorDeInformacoes.verificarTraseiraAccelo(sequencia);
		}
		return sequenciasConstruidas;
	}
}
