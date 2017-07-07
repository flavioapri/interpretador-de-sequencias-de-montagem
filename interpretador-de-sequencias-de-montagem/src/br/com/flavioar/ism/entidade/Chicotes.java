package br.com.flavioar.ism.entidade;

public enum Chicotes {

	$4629(2, "4629", "ATEGO,VINIL"),
	$1102(2, "1102", "AXOR,VINIL"),
	$0233(2, "0233", "ATEGO,TECIDO"),
	$9901(2, "9901", "AXOR,TECIDO"),
	$6007(3, "6007", "ATEGO,VINIL,EP3,EP2"),
	$9502(3, "9502", "AXOR,VINIL,EP3,EP2"),
	$5907(3, "5907", "ATEGO,TECIDO,EP3,EP2"),
	$9302(3, "9302", "AXOR,TECIDO,EP3,EP2"),
	$0133(4, "0133", "ATEGO,ALTO,DS7,TECIDO"),
	$0033(3, "0033", "ATEGO,ALTO,TECIDO"),
	$5507(4, "5507", "ATEGO,ALTO,TECIDO,EP3,EP2"),
	$0901(3, "0901", "AXOR,VINIL,ALTO"),
	$1001(4, "1001", "AXOR,VINIL,ALTO,DS7"),
	$9801(4, "9801", "AXOR,TECIDO,DS7,ALTO"),
	$9701(4, "9701", "AXOR,TECIDO,EX3,ALTO"),
	$9102(4, "9102", "AXOR,ALTO,TECIDO,EP3,EP2");

	private int qtdCodesRelevantes;
	private String numero;
	private String codes;
	
	private Chicotes(int qtdCodesRelevantes, String numero, String codes) {
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
