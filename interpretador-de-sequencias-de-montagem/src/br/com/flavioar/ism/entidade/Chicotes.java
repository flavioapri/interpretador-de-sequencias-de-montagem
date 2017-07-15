package br.com.flavioar.ism.entidade;

public enum Chicotes {

	$4629(2, "4629", "ATEGO VINIL"),
	$1102(2, "1102", "AXOR VINIL"),
	$0233(2, "0233", "ATEGO TECIDO FP6"),
	$9901(2, "9901", "AXOR TECIDO FP6"),
	$6007(3, "6007", "ATEGO VINIL EP3"),
	$9502(3, "9502", "AXOR VINIL EP3"),
	$5907(3, "5907", "ATEGO TECIDO FP6 EP3"),
	$9302(3, "9302", "AXOR TECIDO FP6 EP3"),	
	$0033(3, "0033", "ALTO ATEGO TECIDO FP6"),	
	$0901(3, "0901", "ALTO AXOR VINIL"),
	$5507(4, "5507", "ALTO ATEGO TECIDO FP6 EP3"),
	$0133(4, "0133", "ALTO ATEGO TECIDO FP6 DS7"),
	$1001(4, "1001", "ALTO AXOR VINIL DS7"),
	$9801(4, "9801", "ALTO AXOR TECIDO FP6 DS7"),
	$9701(4, "9701", "ALTO AXOR TECIDO FP6 EX3"),
	$9102(4, "9102", "ALTO AXOR TECIDO FP6 EP3");

	private int qtdCodesRelevantes;
	private String nome;
	private String codes;
	
	private Chicotes(int qtdCodesRelevantes, String nome, String codes) {
		this.qtdCodesRelevantes = qtdCodesRelevantes;
		this.nome = nome;
		this.codes = codes;
	}

	public String getNome() {
		return nome;
	}

	public String getCodes() {
		return codes;
	}
	
	public int getQtdCodesRelevantes() {
		return qtdCodesRelevantes;
	}
}
