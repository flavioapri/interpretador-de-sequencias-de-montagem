package br.com.flavioar.ism.logica;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import br.com.flavioar.ism.entidade.Codes;
import br.com.flavioar.ism.entidade.RevestimentoTraseiro;
import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.entidade.TipoDeVeiculo;

public class ComparadorDeInformacoes {

	public static String compararTipoDeVeiculo(String linha) {
		String tipo = "Não informado";
		for (TipoDeVeiculo tipoDeVeiculo : TipoDeVeiculo.values()) {
			if (linha.contains(tipoDeVeiculo.getBaumuster()))
				tipo = tipoDeVeiculo.getNome();
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

	public static void reflection(Sequencia sequencia, String classe, String metodo) {
		String enumerador = "br.com.flavioar.ism.entidade." + classe;
		organizarCodes(sequencia);
		try {
			Method m1 = sequencia.getClass().getMethod(metodo, String.class);
			Class<?> c = Class.forName(enumerador);
			Object[] o = c.getEnumConstants();
			Class<?> s = o[0].getClass();
			Method m = s.getDeclaredMethod("getCodes");
			Method m2 = s.getDeclaredMethod("getNome");
			for (Object oo : c.getEnumConstants()) {
				if (sequencia.getStringDados().contains((CharSequence) m.invoke(oo))) {
					m1.invoke(sequencia, m2.invoke(oo));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (verificarAcceloSkl(sequencia))
			sequencia.setTipoDeCabina("");
	}

	private static boolean verificarAcceloSkl(Sequencia sequencia) {
		if (sequencia.getTipoDeVeiculo() == TipoDeVeiculo.ACCELO.getNome()
				|| sequencia.getTipoDeVeiculo() == TipoDeVeiculo.SKL.getNome())
			return true;
		return false;
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
		else if (!verificarAcceloSkl(sequencia))
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

		List<String> dadosDaSequencia = Arrays.asList(sequencia.getStringDados().split(" "));

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

}