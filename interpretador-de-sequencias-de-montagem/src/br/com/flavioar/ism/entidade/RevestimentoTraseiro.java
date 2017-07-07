package br.com.flavioar.ism.entidade;

public enum RevestimentoTraseiro {
	
	$4741(1, "4741", "FP6"),
	$0941(1, "0941", "VINIL"),
	$4941(2, "4941", "FP6,F35"),
	$4256(2, "4256", "FP6,F20"),
	$0141(2, "0141", "VINIL,F20"),
	$0841(2, "0841", "VINIL,F35"),
	$4056(3, "4056", "FP6,F20,F35"),
	$0241(3, "0241", "VINIL,F20,F35");
	
	private int qtdCodesRelevantes;
	private String numero;
	private String codes;
	
	private RevestimentoTraseiro(int qtdCodesRelevantes, String numero, String codes) {
		this.qtdCodesRelevantes = qtdCodesRelevantes;
		this.numero = numero;
		this.codes = codes;
	}

	public String getNumero() {
		return numero;
	}

	public String getCodes() {
		return codes;
	}
	
	public int getQtdCodesRelevantes() {
		return qtdCodesRelevantes;
	}
}
