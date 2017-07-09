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
		System.out.println("Interpretador de Sequ�ncias de Montagem - ver 1.0");
		System.out.println("Desenvolvido por Fl�vio Aparecido Ribeiro RE 280.655/0");
		System.out.println("========================================================\n");

		List<String> listaDeSequencias = GeradorDeLista.gerarLista();
		List<Sequencia> sequenciasConstruidas = ConstrutorDeSequencias.construirSequencias(listaDeSequencias);
		sequenciasConstruidas = InterpretadorDeSequencias.interpretarSequencias(sequenciasConstruidas);

		do {
			System.out.println("Deseja exibir as sequ�ncias processadas? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao != 's' && opcao != 'n')
				System.out.println("Voc� informou uma opcao inv�lida. Digite 's' para Sim ou 'n' para N�o.");
		} while (opcao != 's' && opcao != 'n');

		if (opcao == 's') {
			setMetodoDeExibicao();
			exibirSequencias(sequenciasConstruidas);
		}

		do {
			System.out.println("\nDeseja gravar os dados das sequ�ncias processadas em arquivo? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao == 's') {
				setMetodoDeExibicao();
				GeradorDeLista.gravarListaEmArquivo(sequenciasConstruidas, metodoDeExibicao);
			} else if (opcao != 's' && opcao != 'n')
				System.out.println("Voc� informou uma opcao inv�lida. Digite 's' para Sim ou 'n' para N�o.");
		} while (opcao != 's' && opcao != 'n');

		do {
			System.out.println("\nDeseja gravar as sequ�ncias processadas em arquivos individuais para impress�o? [s/n]");
			opcao = s.next().charAt(0);
			if (opcao == 's') {
				setMetodoDeExibicao();
				GeradorDeLista.gravarSequenciaEmArquivo(sequenciasConstruidas, metodoDeExibicao);
			} else if (opcao != 's' && opcao != 'n')
				System.out.println("Voc� informou uma opcao inv�lida. Digite 's' para Sim ou 'n' para N�o.");
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
			System.out.println("Informe o n�mero do modo de exibi��o desejado:\n");

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
				System.out.println("Voc� informou uma opcao inv�lida.");
				System.out.println("Informe algum dos n�meros correspondentes as op��es.\n");
			}
		}
	}
}
