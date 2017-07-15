package br.com.flavioar.ism;

import java.util.ArrayList;
import java.util.List;

import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.logica.ComparadorDeInformacoes;

public class ConstrutorDeSequencias {

	public static List<Sequencia> construirSequencias(List<String> listaDeSequencias) {

		List<Sequencia> sequenciasConstruidas = inicializarListaDeSequenciasConstruidas(listaDeSequencias);

		for (int j = 0; j < sequenciasConstruidas.size(); j++) {
			String linha = listaDeSequencias.get(j);
			int indiceInicial = 0;
			int indiceFinal = 0;
			sequenciasConstruidas.get(j).setNumero(linha.substring(0, 6));
			sequenciasConstruidas.get(j).setTipoDeVeiculo(ComparadorDeInformacoes.compararTipoDeVeiculo(linha));
			sequenciasConstruidas.get(j).setPais(ComparadorDeInformacoes.compararPais(linha));

			if (linha.contains("QVV")) {
				indiceInicial = linha.indexOf("QVV");
				indiceFinal = linha.indexOf(" D ");
				String variante = linha.substring(indiceInicial, indiceFinal);
				sequenciasConstruidas.get(j).setVariante(variante);
			}

			if (linha.contains("IN")) {
				indiceInicial = linha.indexOf("IN");
				String codes = linha.substring(indiceInicial).replace("IN", "");
				sequenciasConstruidas.get(j).setCodes(codes);
			}
		}
		return sequenciasConstruidas;
	}

	private static List<Sequencia> inicializarListaDeSequenciasConstruidas(List<String> listaDeSequencias) {
		List<Sequencia> listaInicializada = new ArrayList<>();

		for (int i = 0; i < listaDeSequencias.size(); i++) {
			listaInicializada.add(new Sequencia());
		}
		return listaInicializada;
	}
}
