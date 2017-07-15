package br.com.flavioar.ism;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import br.com.flavioar.ism.entidade.Sequencia;

public class GeradorDeLista {

	private static Scanner s = new Scanner(System.in);
	private static String diretorioDoUsuario = FileSystemView.getFileSystemView().getHomeDirectory().getPath();

	public static List<String> gerarLista() {
		List<String> listaDeSequencias = new ArrayList<>();

		boolean flag = false;
		do {
			System.out.printf("Informe o nome do arquivo de texto da lista a ser processada:\n");
			String nomeDoArquivo = s.nextLine();

			String caminhoCompletoDoArquivo = diretorioDoUsuario + File.separator + nomeDoArquivo + ".txt";
			try {
				FileReader arquivo = new FileReader(caminhoCompletoDoArquivo);
				BufferedReader leitorDeArquivo = new BufferedReader(arquivo);

				String linha = leitorDeArquivo.readLine();
				// lê a primeira linha
				// a variável "linha" recebe o valor "null" quando o processo
				// de repetição atingir o final do arquivo texto
				while (linha != null) {
					listaDeSequencias.add(linha);
					linha = leitorDeArquivo.readLine();
					// lê da segunda até a última linha
				}
				arquivo.close();
				flag = true;
			} catch (IOException e) {
				System.err.println("Erro na abertura do arquivo " + nomeDoArquivo
						+ ". Não é possível encontrar o arquivo especificado");
			}
		} while (!flag);
		return listaDeSequencias;
	}

	public static void gravarListaEmArquivo(List<Sequencia> sequenciasProcessadas, String metodoDeExibicao) {
		String nomeDoArquivo = "PM17 REVESTIMENTO";

		try {
			FileWriter arquivo = new FileWriter(diretorioDoUsuario + File.separator + nomeDoArquivo + ".txt");
			PrintWriter gravadorDeArquivo = new PrintWriter(arquivo);

			Class<ImpressorDeSequencias> impressor = ImpressorDeSequencias.class;
			Method metodo = impressor.getDeclaredMethod(metodoDeExibicao, Sequencia.class);

			for (Sequencia sequencia : sequenciasProcessadas)
				gravadorDeArquivo.println(metodo.invoke(impressor, sequencia));
			arquivo.close();
		} catch (Exception e) {
			System.err.println("Erro na gravação do arquivo " + nomeDoArquivo);
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void gravarSequenciaEmArquivo(List<Sequencia> sequenciasProcessadas, String metodoDeExibicao) {
		int tamanhoDaLista = sequenciasProcessadas.size();
		String nomeDoArquivo;
		String nomeDoDiretorio = "Sequências " + sequenciasProcessadas.get(0).getNumero() + " até "
				+ sequenciasProcessadas.get(tamanhoDaLista - 1).getNumero();
		new File(diretorioDoUsuario + File.separator + nomeDoDiretorio).mkdir();

		for (Sequencia sequencia : sequenciasProcessadas) {
			nomeDoArquivo = "PM17 - Seq " + sequencia.getNumero();

			try {
				FileWriter arquivo = new FileWriter(diretorioDoUsuario + File.separator + nomeDoDiretorio
						+ File.separator + nomeDoArquivo + ".txt");
				PrintWriter gravadorDeArquivo = new PrintWriter(arquivo);

				Class<ImpressorDeSequencias> impressor = ImpressorDeSequencias.class;
				Method metodo = impressor.getDeclaredMethod(metodoDeExibicao, Sequencia.class);

				gravadorDeArquivo.println(metodo.invoke(impressor, sequencia));

				arquivo.close();
			} catch (Exception e) {
				System.err.println("Erro na gravação do arquivo " + nomeDoArquivo);
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
