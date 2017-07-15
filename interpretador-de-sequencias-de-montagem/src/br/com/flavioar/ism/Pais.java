package br.com.flavioar.ism;

public enum Pais {

	BRASIL("BRASIL", "BRA"), ARGENTINA("ARGENTINA", "771"), OUTRO("OUTRO", "");

	private String nome;
	private String code;

	private Pais(String nome, String code) {
		this.nome = nome;
		this.code = code;
	}

}
