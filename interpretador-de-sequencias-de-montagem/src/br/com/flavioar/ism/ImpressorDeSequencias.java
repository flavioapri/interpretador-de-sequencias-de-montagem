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
		return "=================================================\r\n" + " Sequência: " + sequencia.getNumero()
				+ "\r\n\r\n Chicote: " + sequencia.getChicote() + "\r\n Tipo de Veículo: " + sequencia.getTipoDeVeiculo()
				+ "\r\n Tipo de Cabina: " + sequencia.getTipoDeCabina() + "\r\n País: " + sequencia.getPais()
				+ "\r\n Material: " + sequencia.getMaterial() + "\r\n Lateral: " + sequencia.getRevestimentoLateral()
				+ "\r\n Traseira: " + sequencia.getRevestimentoTraseiro() + "\r\n CODES: " + sequencia.getCodesRelevantes()
				+ "\r\n";
	}

	public static String imprimirAnotacaoDasSequencias(Sequencia sequencia) {		
			return "==================================================" +
			"\r\n Sequência: " + sequencia.getNumero() +
			"\r\n \r\n " +	sequencia.getChicote() +
			"\r\n \r\n " + sequencia.getTipoDeVeiculo() +
			"\r\n " + sequencia.getTipoDeCabina() +			
			"\r\n " +	sequencia.getMaterial() +
			"\r\n " + sequencia.getPais() + 			
			"\r\n " +	sequencia.getCodesRelevantes() +
			"\r\n " +	sequencia.getRevestimentoLateral() +
			"\r\n " +	sequencia.getRevestimentoTraseiro() + "\r\n ";		
	}
}
