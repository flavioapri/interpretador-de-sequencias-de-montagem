package br.com.flavioar.ism.entidade;

public enum TipoDeCabina {

	NORMAL(0, "NORMAL", ""), CENTRAL(1, "CENTRAL", "S28"), CORTINA(1, "CORTINA", "FF8"), LEITO(2, "LEITO",
			"FF8 F04"), ALTO(3, "ALTO", "FF8 F04 DD5");

	private int qtdDeCodesRelevantes;
	private String nome;
	private String codes;

	private TipoDeCabina(int qtdDeCodesRelevantes, String nome, String codes) {
		this.qtdDeCodesRelevantes = qtdDeCodesRelevantes;
		this.nome = nome;
		this.codes = codes;
	}

	public int getQtdDeCodesRelevantes() {
		return qtdDeCodesRelevantes;
	}

	public String getCodes() {
		return codes;
	}
	
	public String getNome() {
		return nome;
	}
}
