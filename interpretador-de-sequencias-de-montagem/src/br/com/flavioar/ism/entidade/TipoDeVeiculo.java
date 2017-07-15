package br.com.flavioar.ism.entidade;

public enum TipoDeVeiculo {

	AXOR_C("958.880", "AXOR"), AXOR_R("958.870", "AXOR"), ATEGO("958.860", "ATEGO"), ACCELO("979.811",
			"ACCELO"), SKL("696.811", "SKL");

	private String baumuster;
	private String nome;

	TipoDeVeiculo(String baumuster, String nome) {
		this.baumuster = baumuster;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getBaumuster() {
		return this.baumuster;
	}
}
