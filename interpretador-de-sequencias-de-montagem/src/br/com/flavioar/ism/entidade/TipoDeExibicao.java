package br.com.flavioar.ism.entidade;

public enum TipoDeExibicao {

	LISTA('1', "imprimirLista", "1. Exibi��o por linha com os dados relevantes"), SEQUENCIAS_COM_NOME_DOS_CAMPO('2',
			"imprimirSequenciaComNomesDosCampos",
			"2. Lista sequ�ncia a sequ�ncia com nomes dos campos"), IMPRIMIR_ANOTACAO_DAS_SEQUENCIAS('3',
					"imprimirAnotacaoDasSequencias",
					"3. Lista sequ�ncia a sequ�ncia somente com os dados relevantes (anota��o)");

	private char opcao;
	private String nome;
	private String descricao;

	private TipoDeExibicao(char opcao, String nome, String descricao) {
		this.opcao = opcao;
		this.nome = nome;
		this.descricao = descricao;
	}

	public char getOpcao() {
		return opcao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
