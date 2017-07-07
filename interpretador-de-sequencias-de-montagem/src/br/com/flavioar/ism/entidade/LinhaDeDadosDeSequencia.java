package br.com.flavioar.ism.entidade;

import java.util.List;

public class LinhaDeDadosDeSequencia {

	List<String> linha;

	public LinhaDeDadosDeSequencia(List<String> linha) {
		this.linha = linha;
	}

	public List<String> getLinha() {
		return linha;
	}

	public void setLinha(List<String> linha) {
		this.linha = linha;
	}

}
