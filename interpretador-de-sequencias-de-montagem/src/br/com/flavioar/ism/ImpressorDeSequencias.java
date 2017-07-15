package br.com.flavioar.ism;

import br.com.flavioar.ism.entidade.Sequencia;

public class ImpressorDeSequencias {

	public static String imprimirLista(Sequencia sequencia) {
		return "[] " + sequencia.getNumero() + " " + sequencia.getTipoDeVeiculo() + " " + sequencia.getTipoDeCabina()
				+ " " + sequencia.getMaterial() + " " + sequencia.getPais() + " " + sequencia.getRevestimentoLateral()
				+ " " + sequencia.getRevestimentoTraseiro() + " " + sequencia.getChicote() + " "
				+ sequencia.getCodesRelevantes();
	}

	public static String imprimirSequenciaComNomesDosCampos(Sequencia sequencia) {
		return "======================="
				+ "\r\n Sequência: " + sequencia.getNumero()
				+ "\r\n Chicote: " + sequencia.getChicote()
				+ "\r\n Tipo de Veículo: " + sequencia.getTipoDeVeiculo()
				+ "\r\n Tipo de Cabina: " + sequencia.getTipoDeCabina()
				+ "\r\n País: " + sequencia.getPais()
				+ "\r\n Material: " + sequencia.getMaterial()
				+ "\r\n Lateral: " + sequencia.getRevestimentoLateral()
				+ "\r\n Traseira: " + sequencia.getRevestimentoTraseiro()
				+ "\r\n " + sequencia.getCodesRelevantes()
				+ "\r\n ";
	}

	public static String imprimirAnotacaoDasSequencias(Sequencia sequencia) {		
			return "======================" +
			"\r\n Sequência: " + sequencia.getNumero() +		
			"\r\n\t" + sequencia.getChicote() +
			"\r\n\t" + sequencia.getTipoDeVeiculo() +
			"\r\n\t" + sequencia.getTipoDeCabina() +			
			"\r\n\t" + sequencia.getMaterial() +
			"\r\n\t" + sequencia.getPais() + 			
			"\r\n " + sequencia.getCodesRelevantes() +
			"\r\n\t" + sequencia.getRevestimentoLateral() +
			"\r\n\t" + sequencia.getRevestimentoTraseiro() + 
			"\r\n\t";		
	}
}
