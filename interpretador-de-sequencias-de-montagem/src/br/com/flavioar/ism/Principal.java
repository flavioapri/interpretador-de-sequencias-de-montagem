package br.com.flavioar.ism;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import br.com.flavioar.ism.entidade.Sequencia;
import br.com.flavioar.ism.entidade.TipoDeExibicao;

public class Principal {
	static Scanner s = new Scanner(System.in);
	static char opcao;
	static String metodoDeExibicao;
	static char opcaoDeExibicao;

	public static void main(String[] args) {
		System.out.println("========================================================");
		System.out.println("Interpretador de Sequências de Montagem - ver 1.0");
		System.out.println("Desenvolvido por Flávio Aparecido Ribeiro RE 280.655/0");
		System.out.println("========================================================\n");

		List<String> listaDeSequencias = GeradorDeLista.gerarLista();
		List<Sequencia> sequenciasConstruidas = ConstrutorDeSequencias.construirSequencias(listaDeSequencias);
		sequenciasConstruidas = InterpretadorDeSequencias.interpretarSequencias(sequenciasConstruidas);

		do {
			System.out.println("Deseja exibir as sequências processadas? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao != 's' && opcao != 'n')
				System.out.println("Você informou uma opcao inválida. Digite 's' para Sim ou 'n' para Não.");
		} while (opcao != 's' && opcao != 'n');

		if (opcao == 's') {
			setMetodoDeExibicao();
			exibirSequencias(sequenciasConstruidas);
		}

		do {
			System.out.println("\nDeseja gravar os dados das sequências processadas em arquivo? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao == 's') {
				setMetodoDeExibicao();
				GeradorDeLista.gravarListaEmArquivo(sequenciasConstruidas, metodoDeExibicao);
			} else if (opcao != 's' && opcao != 'n')
				System.out.println("Você informou uma opcao inválida. Digite 's' para Sim ou 'n' para Não.");
		} while (opcao != 's' && opcao != 'n');

		do {
			System.out.println("\nDeseja gravar as sequências processadas em arquivos individuais para impressão? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao == 's') {
				setMetodoDeExibicao();
				GeradorDeLista.gravarSequenciaEmArquivo(sequenciasConstruidas, metodoDeExibicao);
			} else if (opcao != 's' && opcao != 'n')
				System.out.println("Você informou uma opcao inválida. Digite 's' para Sim ou 'n' para Não.");
		} while (opcao != 's' && opcao != 'n');

		System.out.println("Obrigado!");
	}

	private static void exibirSequencias(List<Sequencia> sequenciasProcessadas) {
		if (!metodoDeExibicao.isEmpty()) {			
			Class<ImpressorDeSequencias> impressor = ImpressorDeSequencias.class;

			try {
				Method metodo = impressor.getDeclaredMethod(metodoDeExibicao, Sequencia.class);
				for (Sequencia sequencia : sequenciasProcessadas)
					System.out.println(metodo.invoke(impressor, sequencia));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void setMetodoDeExibicao() {
		while (opcao == 's') {
			System.out.println("Informe o número do modo de exibição desejado:\n");

			for (TipoDeExibicao exibicao : TipoDeExibicao.values())
				System.out.println(exibicao.getDescricao());

			opcaoDeExibicao = s.next().charAt(0);
			for (TipoDeExibicao exibicao : TipoDeExibicao.values()) {
				if (opcaoDeExibicao == exibicao.getOpcao()) {
					metodoDeExibicao = exibicao.getNome();
					opcao = 'n';
				}
			}

			if (metodoDeExibicao.isEmpty()) {
				System.out.println("Você informou uma opcao inválida.");
				System.out.println("Informe algum dos números correspondentes as opções.\n");
			}
		}
	}
}
