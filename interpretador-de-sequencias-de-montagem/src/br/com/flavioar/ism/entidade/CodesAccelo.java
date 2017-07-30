package br.com.flavioar.ism.entidade;

public enum CodesAccelo {

	JANELA("F35"), REDE("FF4");
	
	private String code;

	private CodesAccelo(String code) {
		this.code = code;
	}	
}
