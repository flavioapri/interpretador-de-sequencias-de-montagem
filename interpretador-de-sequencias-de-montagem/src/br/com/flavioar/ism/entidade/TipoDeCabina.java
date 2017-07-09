package br.com.flavioar.ism.entidade;

public enum TipoDeCabina {

	NORMAL(0, ""), CENTRAL(1, "S28"), CORTINA(1, "FF8"), LEITO(2, "FF8 F04"), ALTO(3, "FF8 F04 DD5");

	private int qtdDeCodesRelevantes;
	private String codes;

	private TipoDeCabina(int qtdDeCodesRelevantes, String codes) {
		this.qtdDeCodesRelevantes = qtdDeCodesRelevantes;
		this.codes = codes;
	}

	public int getQtdDeCodesRelevantes() {
		return qtdDeCodesRelevantes;
	}

	public String getCodes() {
		return codes;
	}
}
