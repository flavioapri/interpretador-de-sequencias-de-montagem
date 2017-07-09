package br.com.flavioar.ism.logica;

import java.util.Arrays;
import java.util.List;

import br.com.flavioar.ism.entidade.Chicotes;
import br.com.flavioar.ism.entidade.Codes;
import br.com.flavioar.ism.entidade.RevestimentoTraseiro;
import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.entidade.TipoCarro;
import br.com.flavioar.ism.entidade.TipoDeCabina;

public class ComparadorDeInformacoes {

	public static String compararTipoDeCarro(String linha) {
		String tipo = "Não informado";
		for (TipoCarro tipoCarro : TipoCarro.values()) {
			if (linha.contains(tipoCarro.getBaumuster()))
				tipo = tipoCarro.getNome();
		}
		return tipo;
	}

	public static String compararPais(String linha) {
		String pais = "INDEFINIDO";
		if (linha.contains("BR"))
			pais = "BRASIL";
		else if (linha.contains("771"))
			pais = "ARGENTINA";
		else
			pais = "OUTRO";
		return pais;
	}

	public static void verificarCabinaCompacta(Sequencia sequencia) {
		if (!sequencia.getVariante().contains("QVV")) {
			sequencia.setTipoDeCabina("COMPACTA");
			sequencia.setChicote("");
			sequencia.setMaterial("");
			sequencia.setPais("");
			sequencia.setCodes("");
			sequencia.setRevestimentoLateral("");
			sequencia.setRevestimentoTraseiro("");
		}
	}

	public static void compararTipoDeCabina(Sequencia sequencia) {
		organizarCodes(sequencia);
		System.out.println(sequencia.getCodes());
		for (TipoDeCabina tipo : TipoDeCabina.values()) {
			if (sequencia.getCodes().contains(tipo.getCodes()))
				sequencia.setTipoDeCabina(tipo.name());			
		}
		if (sequencia.getTipoDeVeiculo() == TipoCarro.ACCELO.getNome()
				|| sequencia.getTipoDeVeiculo() == TipoCarro.SKL.getNome())
			sequencia.setTipoDeCabina("");
	}

	private static void organizarCodes(Sequencia sequencia) {
		StringBuilder codesOrganizados = new StringBuilder();

		for (Codes code : Codes.values()) {
			if (sequencia.getCodes().contains(code.name())) {
				codesOrganizados.append(code.name());
				codesOrganizados.append(" ");
			}
		}
		sequencia.setCodes(codesOrganizados.toString());
	}

	public static void compararMaterial(Sequencia sequencia) {
		if (sequencia.getCodes().contains(Codes.FP6.name()))
			sequencia.setMaterial(Codes.FP6.getNomeUsual());
		else if (sequencia.getTipoDeVeiculo() != TipoCarro.ACCELO.getNome()
				&& sequencia.getTipoDeVeiculo() != TipoCarro.SKL.getNome())
			if (!sequencia.getCodes().contains(Codes.FP6.name()))
				sequencia.setMaterial("VINIL");
	}

	public static void compararRevestimentoLateral(Sequencia sequencia) {
		if (sequencia.getCodes().contains(Codes.F04.name())) {
			if (sequencia.getPais().contains("ARGENTINA"))
				sequencia.setRevestimentoLateral("73 / 79");
			else if (sequencia.getMaterial().contains("VINIL") && sequencia.getCodes().contains("F04"))
				sequencia.setRevestimentoLateral("57 / 10");
			else
				sequencia.setRevestimentoLateral("75 / 79");
		}
	}

	public static void compararRevestimentoTraseiro(Sequencia sequencia) {
		if (sequencia.getCodes().contains("F04"))
			return;

		List<String> dadosDaSequencia = Arrays.asList(sequencia.stringDados().split(" "));

		for (RevestimentoTraseiro revestimento : RevestimentoTraseiro.values()) {
			int contador = 0;
			String codesRevestimento = revestimento.getCodes();
			List<String> informacoesRevestimento = Arrays.asList(codesRevestimento.split(","));
			for (String informacao : informacoesRevestimento) {
				if (dadosDaSequencia.contains(informacao))
					contador++;
			}
			if (contador == revestimento.getQtdCodesRelevantes())
				sequencia.setRevestimentoTraseiro(revestimento.getNumero());
		}
	}

	public static void compararCodesRelevantes(Sequencia sequencia) {
		StringBuilder codesRelevantes = new StringBuilder("");
		for (Codes code : Codes.values()) {
			if (sequencia.getCodes().contains(code.name()) && code.isRelevante())
				codesRelevantes.append(code.name() + " ");
		}
		sequencia.setCodesRelevantes(codesRelevantes.toString());
	}

	public static void compararChicote(Sequencia sequencia) {
		List<String> dadosDaSequencia = Arrays.asList(sequencia.stringDados().split(" "));
		for (Chicotes chicote : Chicotes.values()) {
			int contador = 0;
			String codesChicote = chicote.getCodes();
			List<String> informacoesChicote = Arrays.asList(codesChicote.split(","));
			for (String informacao : informacoesChicote) {
				if (dadosDaSequencia.contains(informacao))
					contador++;
			}
			if (contador == chicote.getQtdCodesRelevantes())
				sequencia.setChicote(chicote.getNumero());
		}
	}
}
